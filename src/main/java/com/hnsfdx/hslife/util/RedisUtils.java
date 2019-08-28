package com.hnsfdx.hslife.util;

import com.hnsfdx.hslife.pojo.User;
import com.hnsfdx.hslife.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;
import redis.clients.jedis.commands.JedisCommands;
import redis.clients.jedis.commands.MultiKeyCommands;
import redis.clients.jedis.params.SetParams;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.stream.Stream;

@Configuration
public class RedisUtils {
    private static final Logger logger = LoggerFactory.getLogger(RedisUtils.class);

    private StringRedisTemplate stringRedisTemplate;

    private UserService userService;

    @Autowired
    public RedisUtils(StringRedisTemplate stringRedisTemplate, UserService userService) {
        this.stringRedisTemplate = stringRedisTemplate;
        this.userService = userService;
    }

    private static final ThreadLocal<String> lockId = new ThreadLocal<>();
    private static final String UNLOCK_LUA;
    private static final String RANK_KEY = "UsersRank";

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("if redis.call(\"get\",KEYS[1]) == ARGV[1] ");
        sb.append("then ");
        sb.append("    return redis.call(\"del\",KEYS[1]) ");
        sb.append("else ");
        sb.append("    return 0 ");
        sb.append("end ");
        UNLOCK_LUA = sb.toString();
    }

    // 通用式的redis分布式锁
    public boolean lock(String key, long expire) {
        try {
            String result = stringRedisTemplate.execute(new RedisCallback<String>() {
                @Override
                public String doInRedis(RedisConnection connection) throws DataAccessException {
                    JedisCommands commands = (JedisCommands) connection.getNativeConnection();
                    String uuid = UUID.randomUUID().toString();
                    lockId.set(uuid);
                    SetParams setParams = new SetParams();
                    setParams.nx().px(expire);
                    return commands.set(key, uuid, setParams);
                }
            });
            return !StringUtils.isEmpty(result);
        } catch (Exception e) {
            logger.error("==================RedisLockException===================");
            logger.error("RedisLock occured an exception : {}", e);
            logger.error("RedisLock key : {}", key);
            logger.error("==========================End==========================");
            lockId.remove();
        }
        return false;
    }

    // 自定义式的redis分布式锁，带尝试次数
    public boolean lock(String key, long expire, int retryTimes, long sleepTime) {
        boolean result = lock(key, expire);
        while (!result && retryTimes-- > 0) {
            try {
                logger.debug("====================RedisLockFalse=====================");
                logger.debug("RedisLock key : {}", key);
                logger.debug("RedisLock failed, retrying... {}", retryTimes);
                logger.debug("==========================End==========================");
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                logger.error("===============RedisLockRetryInterrupted===============");
                logger.error("RedisLock is interrupted : {}", e);
                logger.error("==========================End==========================");
                return false;
            }
            result = lock(key, expire);
        }
        return result;
    }

    // 释放redis分布式锁
    public boolean unlock(String key) {
        try {
            List<String> keys = new ArrayList<>();
            keys.add(key);
            List<String> args = new ArrayList<>();
            args.add(lockId.get());
            Long result = stringRedisTemplate.execute(new RedisCallback<Long>() {
                public Long doInRedis(RedisConnection connection) throws DataAccessException {
                    Object nativeConnection = connection.getNativeConnection();
                    // 集群模式和单机模式虽然执行脚本的方法一样，但是没有共同的接口，所以只能分开执行
                    // 集群模式
                    if (nativeConnection instanceof JedisCluster) {
                        return (Long) ((JedisCluster) nativeConnection).eval(UNLOCK_LUA, keys, args);
                    }

                    // 单机模式
                    else if (nativeConnection instanceof Jedis) {
                        return (Long) ((Jedis) nativeConnection).eval(UNLOCK_LUA, keys, args);
                    }
                    return 0L;
                }
            });
            return result != null && result > 0;
        } catch (Exception e) {
            logger.error("=================RedisUnlockException==================");
            logger.error("RedisLock key : {}, RedisLock clientId : {}", key, lockId.get());
            logger.error("RedisLock occured an exception : {}", e);
            logger.error("==========================End==========================");
        }
        lockId.remove();
        return false;
    }


    // 缓存排行榜前15数据,过期时间以小时制，从MySQL中读
    public boolean setRankCache(long expire) {
        List<User> users = userService.getUsersRank15();
        Stream<User> userStream = users.stream();
        try {
            userStream.forEach((item) -> stringRedisTemplate
                    .opsForZSet()
                    .add(RANK_KEY, item.getUserName(), item.getScore()));
        } catch (Exception e) {
            stringRedisTemplate.delete(RANK_KEY);
            return false;
        }
        // 如果全部添加成功则设置过期时间,否则直接删除缓存,准备重新配置缓存
        stringRedisTemplate.expire(RANK_KEY, expire, TimeUnit.HOURS);
        return true;
    }

    // 获得缓存中的数据并用List保存起来
    public List<Map<String, String>> getRankCache() {
        Set<ZSetOperations.TypedTuple<String>> rankSet = stringRedisTemplate
                .opsForZSet()
                .reverseRangeWithScores(RANK_KEY, 0, -1);
        List<Map<String, String>> rankList = new ArrayList<>();
        rankSet.forEach((item) -> {
            Map<String, String> rankMap = new HashMap<>();
            rankMap.put(item.getValue(), String.valueOf(item.getScore()));
            rankList.add(rankMap);
        });
        return rankList;
    }

    // 找到pattern匹配的key
    private Set<String> scan(String pattern) {
        return stringRedisTemplate.execute((RedisCallback<Set<String>>) connection -> {
            Set<String> keys = new HashSet<>();
            JedisCommands commands = (JedisCommands) connection.getNativeConnection();
            MultiKeyCommands multiKeyCommands = (MultiKeyCommands) commands;
            ScanParams scanParams = new ScanParams();
            scanParams.match("*" + pattern + "*");
            scanParams.count(1000);
            ScanResult<String> scan = multiKeyCommands.scan("0", scanParams);
            while (null != scan.getCursor()) {
                keys.addAll(scan.getResult());
                if (!"0".equals(scan.getCursor()) && scan.getCursor() != null) {
                    scan = multiKeyCommands.scan(scan.getCursor(), scanParams);
                    continue;
                } else {
                    break;
                }
            }
            return keys;
        });
    }

    public void delPatternKeys(String pattern) {
        Set<String> keys = scan(pattern);
        keys.forEach(item -> stringRedisTemplate.delete(item));
    }
}

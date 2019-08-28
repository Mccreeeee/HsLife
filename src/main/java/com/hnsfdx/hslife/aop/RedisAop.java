package com.hnsfdx.hslife.aop;

import com.alibaba.fastjson.JSON;
import com.hnsfdx.hslife.exception.AuthException;
import com.hnsfdx.hslife.util.RedisUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;


@Aspect
@Component
public class RedisAop {
    // slf4j logger
    private static final Logger logger = LoggerFactory.getLogger(RedisAop.class);
    // 记录运行时间
    private static final ThreadLocal<Long> startTime = new ThreadLocal<>();
    // redis缓存
    private StringRedisTemplate stringRedisTemplate;
    private RedisUtils redisUtils;

    @Autowired
    public RedisAop(StringRedisTemplate stringRedisTemplate, RedisUtils redisUtils) {
        this.stringRedisTemplate = stringRedisTemplate;
        this.redisUtils = redisUtils;
    }


    // 读切面
    @Pointcut("@annotation(com.hnsfdx.hslife.annotation.ReadCache)")
    public void readPointCut() {

    }

    // 写切面
    @Pointcut("@annotation(com.hnsfdx.hslife.annotation.WriteCache)")
    public void writePointCut() {

    }

    @Around(value = "readPointCut()")
    public Object readEnhancement(ProceedingJoinPoint pjp) {
        startTime.set(System.currentTimeMillis());
        Object[] args = pjp.getArgs();
        String id = null;
        if (args != null && args.length > 0) {
            id = String.valueOf(args[0]);
            for (int i = 1; i < args.length; i++) {
                id += String.valueOf(args[i]);
            }
        }
        String methodName = pjp.getSignature().getName();
        Method method = ((MethodSignature) pjp.getSignature()).getMethod();
        Type type = method.getGenericReturnType();
        String className = pjp.getSignature().getDeclaringType().getSimpleName();
        String redisKey = id + ":" + className + "." + methodName;
        String res = stringRedisTemplate.opsForValue().get(redisKey);
        // 缓存中存在就取出并处理Redis中的缓存，将其转换为对应的返回值返回
        if (res != null) {
            logger.info("**********从Redis中查到了数据**********");
            logger.info("Redis的KEY值:" + redisKey);
            logger.info("Redis的VALUE值:" + res);
            long endTime = System.currentTimeMillis();
            logger.info("Redis缓存查到数据所用时间:" + (endTime - startTime.get()));
            logger.info("**********从Redis查到数据**********");
            startTime.remove();
            return JSON.parseObject(res, type);
        } else {
            logger.info("**********没有从Redis查到数据**********");
            logger.info("Redis缓存Aop处理所用时间:" + (System.currentTimeMillis() - startTime.get()));
            logger.info("**********没有从Redis查到数据**********");
            startTime.remove();
            // 否则进行查数据库操作，并存入Redis，可使用消息队列
            try {
                startTime.set(System.currentTimeMillis());
                logger.info("**********从MySQL中查数据，并进行缓存**********");
                Object object = pjp.proceed();
                String json = JSON.toJSONString(object);
                stringRedisTemplate.opsForValue().set(redisKey, json, 8, TimeUnit.MINUTES);
                logger.info("进行查询与缓存处理所用时间:" + (System.currentTimeMillis() - startTime.get()));
                logger.info("**********数据成功存储到缓存中**********");
                startTime.remove();
                return object;
            } catch (Throwable throwable) {
                throw new AuthException();
            }
        }
    }

    // 淘汰可能会有问题的所有缓存
    @AfterReturning(pointcut = "writePointCut()", returning = "object")
    public void writeEnhancement(Object object, JoinPoint joinPoint) {
        // 返回1代表操作数据库成功，要淘汰Redis缓存
        if (object.equals(1)) {
            String pattern = joinPoint.getSignature().getDeclaringType().getSimpleName();
            redisUtils.delPatternKeys(pattern);
        }
    }
}

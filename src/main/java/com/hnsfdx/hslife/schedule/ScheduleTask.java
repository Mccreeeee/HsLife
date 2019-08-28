package com.hnsfdx.hslife.schedule;

import com.hnsfdx.hslife.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTask {
    private RedisUtils redisUtils;

    @Autowired
    public ScheduleTask(RedisUtils redisUtils) {
        this.redisUtils = redisUtils;
    }

    @Scheduled(fixedDelay = 1000 * 60 * 60)
    public void setRank15Cache() {
        redisUtils.setRankCache(1);
    }
}

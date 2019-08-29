package com.hnsfdx.hslife.async.consumer;

import com.alibaba.fastjson.JSON;
import com.hnsfdx.hslife.async.EventModel;
import com.hnsfdx.hslife.async.EventType;
import com.hnsfdx.hslife.pojo.Answer;
import com.hnsfdx.hslife.service.AnswerService;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
@RocketMQMessageListener(topic = "answer", consumerGroup = "answer_consumer")
public class AnswerConsumer implements RocketMQListener<MessageExt> {
    private AnswerService answerService;
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    public AnswerConsumer(AnswerService answerService, StringRedisTemplate stringRedisTemplate) {
        this.answerService = answerService;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public void onMessage(MessageExt messageExt) {
        EventModel eventModel = JSON.parseObject(messageExt.getBody(), EventModel.class);
        if (stringRedisTemplate.opsForValue().get(messageExt.getKeys()) == null) {
            Answer answer = JSON.parseObject(eventModel.getEventBody(), Answer.class);
            if (eventModel.getEventType() == EventType.INSERT) {
                answerService.addSingleAnswer(answer);
            }
            stringRedisTemplate.opsForValue().setIfAbsent(messageExt.getKeys(), System.currentTimeMillis() + "", 5, TimeUnit.MINUTES);
        }
    }
}

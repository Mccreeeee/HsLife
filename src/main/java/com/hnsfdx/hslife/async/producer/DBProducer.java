package com.hnsfdx.hslife.async.producer;

import com.alibaba.fastjson.JSON;
import com.hnsfdx.hslife.async.EventModel;
import com.hnsfdx.hslife.async.EventType;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.MessageConst;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DBProducer {
    private static final Logger logger = LoggerFactory.getLogger(DBProducer.class);
    private RocketMQTemplate rocketMQTemplate;

    @Autowired
    public DBProducer(RocketMQTemplate rocketMQTemplate) {
        this.rocketMQTemplate = rocketMQTemplate;
    }

    private void sendMsg(String topic, String msg, String key) {
        rocketMQTemplate.asyncSend(topic,
                MessageBuilder.withPayload(msg).setHeader(MessageConst.PROPERTY_KEYS, key).build(),
                new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                logger.info("**********发送消息数据成功**********");
                logger.info("msgId:" + sendResult.getMsgId() + ";"
                        + "msgoffsetId" + sendResult.getOffsetMsgId() + ";"
                        + "msgqueue" + sendResult.getMessageQueue() + ";"
                        + "queueoffset" + sendResult.getQueueOffset() + ";"
                        + "status" + sendResult.getSendStatus());
                logger.info("**********发送消息数据成功**********");
            }

            @Override
            public void onException(Throwable throwable) {
                logger.error("**********发送消息数据异常**********");
                throwable.printStackTrace();
                logger.error("**********发送消息数据异常**********");
            }
        });
    }

    public void sendMsg(String topic, String objectJson, EventType type) {
        EventModel eventModel = new EventModel();
        eventModel.setEventType(type);
        eventModel.setEventBody(objectJson);
        String msg = JSON.toJSONString(eventModel);
        sendMsg(topic, msg, UUID.randomUUID().toString());
    }
}

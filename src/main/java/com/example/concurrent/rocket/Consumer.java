package com.example.concurrent.rocket;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

@Slf4j
public class Consumer {
    public static void main(String[] args) {
        try {
            DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("group5");
            consumer.setNamesrvAddr("127.0.0.1:9876");
            consumer.subscribe("TransactionTopic","*");

            // consumer.setMessageModel(MessageModel.BROADCASTING);

            consumer.registerMessageListener((MessageListenerConcurrently) (msgs , context) -> {
                for (MessageExt msg : msgs) {
                    log.info("-----------消费------------" + Thread.currentThread().getName());
                    log.info(msg.getTags() + " , " + new String(msg.getBody()));
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            });
            consumer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }
}

package com.example.concurrent.rocket;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

@Slf4j
public class Producer {

    public static void main(String[] args) {
        try {
            TransactionMQProducer producer = new TransactionMQProducer("group5");
            producer.setNamesrvAddr("127.0.0.1:9876");

            producer.setTransactionListener(new TransactionListener() {
                @Override
                public LocalTransactionState executeLocalTransaction(Message message, Object o) {
                    if ("Tag1".equals(message.getTags())) {
                        log.info("-------executeLocalTransaction------1");
                        return LocalTransactionState.COMMIT_MESSAGE;
                    }
                    else if ("Tag2".equals(message.getTags())) {
                        log.info("-------executeLocalTransaction------2");
                        return LocalTransactionState.ROLLBACK_MESSAGE;
                    }
                    else if ("Tag3".equals(message.getTags())) {
                        log.info("-------executeLocalTransaction------3");
                        return LocalTransactionState.UNKNOW;
                    }
                    return LocalTransactionState.UNKNOW;
                }

                @Override
                public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
                    log.info("-------checkLocalTransaction------" + messageExt.getTags());
                    return LocalTransactionState.COMMIT_MESSAGE;
                }
            });

            producer.start();

            String[] tags = {"Tag1","Tag2","Tag3"};
            for (int i = 0; i < 3; i++) {
                Message message = new Message("TransactionTopic",tags[i],("hello " + i).getBytes());
                SendResult sendResult = producer.sendMessageInTransaction(message, null);
                log.info("---------发送结果---------" + sendResult.toString());

                Thread.sleep(2000);
            }

            // producer.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


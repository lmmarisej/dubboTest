package org.lmmarise.rocketmq.consumer.listener;

import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/11/1 1:42 上午
 */
@Component
@RocketMQMessageListener(topic = "TopicTest", consumerGroup = "CONSUMER_GROUP_DEMO", consumeMode = ConsumeMode.ORDERLY)
public class OrderListener implements RocketMQListener<String> {

    @Override
    public void onMessage(String order) {
        System.out.println("TopicTest receive: " + order + ", receiveTime = " + System.currentTimeMillis());
    }
}

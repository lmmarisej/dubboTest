package org.lmmarise.rocketmq.consumer;

import org.lmmarise.rocketmq.consumer.channel.InputChannel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/11/1 1:38 上午
 */
@EnableBinding({Sink.class, InputChannel.class})
@SpringBootApplication
public class Application {

    @StreamListener(value = InputChannel.ORDER_INPUT)
    public void receive(String receiveMsg) {
        System.out.println("receive: " + receiveMsg);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

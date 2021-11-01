package org.lmmarise.rocketmq.binder.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/11/1 12:16 下午
 */
//@RestController
@Component
public class ProduceController {
//
//    @Autowired
//    private StreamClient source;

    @Autowired
    private Source source;

//    @StreamListener("input1")
//    public void test(String message){
//        System.out.println(message);
//    }

    @PostConstruct
    private void init() throws InterruptedException {
        MessageBuilder builder = MessageBuilder.withPayload("init...");
        Message message = builder.build();
        source.output().send(message);
        System.out.println("init...");
    }
}

package org.lmmarise.rocketmq.binder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/11/1 12:16 下午
 */
@SpringBootApplication
@EnableBinding({Source.class, Sink.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

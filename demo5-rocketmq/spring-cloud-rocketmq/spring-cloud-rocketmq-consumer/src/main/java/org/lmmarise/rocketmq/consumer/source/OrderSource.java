package org.lmmarise.rocketmq.consumer.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/11/1 1:43 上午
 */
public interface OrderSource {
    String OUTPUT = "orderOutput";

    @Output(OrderSource.OUTPUT)
    MessageChannel output();
}

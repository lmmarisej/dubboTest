package org.lmmarise.rocketmq.consumer.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/11/1 1:40 上午
 */
public interface InputChannel {
    String USER_INPUT = "userInput";

    String ORDER_INPUT = "orderInput";

    @Input(InputChannel.USER_INPUT)
    SubscribableChannel userInput();

    @Input(InputChannel.ORDER_INPUT)
    SubscribableChannel orderInput();
}

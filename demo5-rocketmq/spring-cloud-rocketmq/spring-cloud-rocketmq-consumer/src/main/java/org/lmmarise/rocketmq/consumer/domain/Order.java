package org.lmmarise.rocketmq.consumer.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/11/1 1:41 上午
 */
@Getter
@Setter
@AllArgsConstructor
public class Order {
    private String orderId;
    private String address;
}

package org.lmmarise.seata.order.service;

import org.lmmarise.seata.common.dto.OrderDto;
import org.lmmarise.seata.common.response.ObjectResponse;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/10/29 11:10 下午
 */
public interface IOrderService {
    /**
     * 创建订单
     */
    ObjectResponse<OrderDto> createOrder(OrderDto orderDto);
}

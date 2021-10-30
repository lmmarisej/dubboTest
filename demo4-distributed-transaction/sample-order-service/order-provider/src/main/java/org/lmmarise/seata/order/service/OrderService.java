package org.lmmarise.seata.order.service;

import org.lmmarise.seata.order.entity.Order;
import org.lmmarise.seata.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/10/29 10:27 下午
 */
@Service
public class OrderService {

    @Resource
    private OrderRepository orderRepository;

    /**
     * 创建订单
     */
    public void createOrder(Order order) {
        orderRepository.save(order);
    }
}

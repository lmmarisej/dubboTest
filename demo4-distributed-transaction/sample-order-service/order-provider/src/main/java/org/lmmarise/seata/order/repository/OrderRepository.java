package org.lmmarise.seata.order.repository;

import org.lmmarise.seata.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/10/29 11:22 下午
 */
public interface OrderRepository extends JpaRepository<Order, Integer> {
}

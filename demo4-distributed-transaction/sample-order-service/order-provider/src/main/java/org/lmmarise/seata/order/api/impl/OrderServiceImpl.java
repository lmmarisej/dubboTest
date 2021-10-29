package org.lmmarise.seata.order.api.impl;

import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.lmmarise.seata.account.service.IAccountService;
import org.lmmarise.seata.common.dto.AccountDto;
import org.lmmarise.seata.common.dto.OrderDto;
import org.lmmarise.seata.common.response.ObjectResponse;
import org.lmmarise.seata.order.convert.OrderConvert;
import org.lmmarise.seata.order.entity.Order;
import org.lmmarise.seata.order.service.IOrderService;
import org.lmmarise.seata.order.service.OrderService;

import javax.annotation.Resource;
import java.util.UUID;

import static org.lmmarise.seata.common.constants.ResponseCode.*;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/10/29 11:36 下午
 */
@Slf4j
@Service
public class OrderServiceImpl implements IOrderService {

    @Resource
    private OrderConvert orderConvert;

    @Resource
    private OrderService orderService;
    @Reference
    IAccountService accountService;

    @Override
    public ObjectResponse<OrderDto> createOrder(OrderDto orderDto) {
        log.info("全局事务ID：" + RootContext.getXID());
        ObjectResponse<OrderDto> response = new ObjectResponse<>();
        try {
            // 账户扣款
            AccountDto accountDto = new AccountDto();
            accountDto.setUserId(orderDto.getUserId());
            accountDto.setBalance(orderDto.getOrderAmount());
            ObjectResponse<?> accountRes = accountService.decreaseAccount(accountDto);
            // 创建订单
            Order order = orderConvert.dto2Order(orderDto);
            order.setOrderNo(UUID.randomUUID().toString());
            orderService.createOrder(order);
            // 判断扣款状态（判断可以前置）
            if (accountRes.getCode() != SUCCESS.getCode()) {
                return response.setResponseCode(FAILED);
            }
            response.setResponseCode(SUCCESS);
        } catch (Exception e) {
            log.error("createOrder Occur Exception:" + e);
            response.setResponseCode(SYSTEM_EXCEPTION);
            response.setMsg(e.getMessage());
        }
        return response;
    }
}

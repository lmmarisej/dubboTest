package org.lmmarise.seata.web.service;

import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.lmmarise.seata.common.constants.ResponseCode;
import org.lmmarise.seata.common.dto.OrderDto;
import org.lmmarise.seata.common.dto.OrderRequest;
import org.lmmarise.seata.common.dto.ProductDto;
import org.lmmarise.seata.common.response.ObjectResponse;
import org.lmmarise.seata.order.service.IOrderService;
import org.lmmarise.seata.repo.service.IRepoService;
import org.springframework.stereotype.Service;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/10/29 11:10 下午
 */
@Slf4j
@Service
public class RestOrderServiceImpl implements IRestOrderService {

    @Reference
    IRepoService repoService;
    @Reference
    IOrderService orderService;

    @Override
    @GlobalTransactional(timeoutMills = 300000, name = "spring-cloud-seata-rest")   // 非线程安全
    public ObjectResponse<?> handleBusiness(OrderRequest orderRequest) throws Exception {
        log.info("开始全局事务:xid=" + RootContext.getXID());
        log.info("begin order: " + orderRequest);
        ObjectResponse<?> response = new ObjectResponse<>();
        response.setResponseCode(ResponseCode.SUCCESS);
        // 1. 扣减库存
        ProductDto productDto = new ProductDto();
        productDto.setProductCode(orderRequest.getProductCode());
        productDto.setCount(orderRequest.getCount());
        ObjectResponse<?> repoRes = repoService.decreaseRepo(productDto);
        if (repoRes.getCode() != ResponseCode.SUCCESS.getCode()) {
            throw new Exception("扣减库存失败：" + repoRes.getMsg());
        }
        // 2. 创建订单
        OrderDto orderDto = new OrderDto();
        orderDto.setUserId(orderRequest.getUserId());
        orderDto.setOrderAmount(orderRequest.getAmount());
        orderDto.setOrderCount(orderRequest.getCount());
        orderDto.setProductCode(orderRequest.getProductCode());
        ObjectResponse<OrderDto> orderRes = orderService.createOrder(orderDto);
        if (orderRes.getCode() != ResponseCode.SUCCESS.getCode()) {
            throw new Exception("订单创建失败：" + orderRes.getMsg());
        }
        response.setData(orderRes.getData());
        // 失败测试
        if (orderRequest.getProductCode().equals("GP20200202002")) {
            throw new Exception("分布式事物失败测试");
        }
        return response;
    }
}

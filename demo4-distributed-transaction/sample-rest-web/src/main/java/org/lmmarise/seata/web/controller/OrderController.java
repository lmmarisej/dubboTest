package org.lmmarise.seata.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.lmmarise.seata.common.dto.OrderRequest;
import org.lmmarise.seata.common.response.ObjectResponse;
import org.lmmarise.seata.web.service.IRestOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/10/29 11:10 下午
 */
@Slf4j
@RestController
public class OrderController {

    @Autowired
    IRestOrderService restOrderService;

    @PostMapping("/order")
    ObjectResponse<?> order(@RequestBody OrderRequest orderRequest) throws Exception {
        return restOrderService.handleBusiness(orderRequest);
    }
}

package org.lmmarise.seata.web.service;


import org.lmmarise.seata.common.dto.OrderRequest;
import org.lmmarise.seata.common.response.ObjectResponse;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/10/29 11:10 下午
 */
public interface IRestOrderService {

    ObjectResponse<?> handleBusiness(OrderRequest orderRequest) throws Exception;
}

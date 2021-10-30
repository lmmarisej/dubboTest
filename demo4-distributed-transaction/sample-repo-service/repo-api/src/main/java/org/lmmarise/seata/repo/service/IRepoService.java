package org.lmmarise.seata.repo.service;

import org.lmmarise.seata.common.dto.ProductDto;
import org.lmmarise.seata.common.response.ObjectResponse;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/10/30 11:02 上午
 */
public interface IRepoService {
    /**
     * 扣减库存
     */
    ObjectResponse<?> decreaseRepo(ProductDto productDto);
}

package org.lmmarise.seata.repo.api.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.lmmarise.seata.common.constants.ResponseCode;
import org.lmmarise.seata.common.dto.ProductDto;
import org.lmmarise.seata.common.response.ObjectResponse;
import org.lmmarise.seata.repo.service.IRepoService;
import org.lmmarise.seata.repo.service.RepoService;

import javax.annotation.Resource;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/10/30 11:05 上午
 */
@Slf4j
@Service
public class RepoServiceImpl implements IRepoService {

    @Resource
    private RepoService repoService;

    @Override
    public ObjectResponse<?> decreaseRepo(ProductDto productDto) {
        ObjectResponse<?> response = new ObjectResponse<>();
        try {
            int repo = repoService.decreaseRepo(productDto.getProductCode(), productDto.getCount());
            if (repo > 0) {
                return response.setResponseCode(ResponseCode.SUCCESS);
            }
            response.setResponseCode(ResponseCode.FAILED);
        } catch (Exception e) {
            log.error("decreaseRepo Occur Exception:" + e);
            response.setResponseCode(ResponseCode.SYSTEM_EXCEPTION);
            response.setMsg(e.getMessage());
        }
        return response;
    }
}

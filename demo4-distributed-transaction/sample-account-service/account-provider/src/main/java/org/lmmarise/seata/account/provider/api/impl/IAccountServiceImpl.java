package org.lmmarise.seata.account.provider.api.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.lmmarise.seata.account.provider.service.AccountService;
import org.lmmarise.seata.account.service.IAccountService;
import org.lmmarise.seata.common.constants.ResponseCode;
import org.lmmarise.seata.common.dto.AccountDto;
import org.lmmarise.seata.common.response.ObjectResponse;

import javax.annotation.Resource;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/10/29 11:33 下午
 */
@Slf4j
@Service
public class IAccountServiceImpl implements IAccountService {

    @Resource
    private AccountService accountService;

    @Override
    public ObjectResponse<?> decreaseAccount(AccountDto accountDto) {
        try {
            int rs = accountService.decreaseAccount(accountDto.getUserId(), accountDto.getBalance().doubleValue());
            if (rs > 0) {
                return new ObjectResponse<>(ResponseCode.SUCCESS);
            }
            return new ObjectResponse<>(ResponseCode.FAILED);
        } catch (Exception e) {
            log.error("decreaseAccount Occur Exception:" + e);
            return new ObjectResponse<>(ResponseCode.SYSTEM_EXCEPTION.getCode(),
                    ResponseCode.SYSTEM_EXCEPTION.getMessage() + "-" + e.getMessage(), "");
        }
    }
}

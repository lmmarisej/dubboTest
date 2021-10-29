package org.lmmarise.seata.account.service;

import org.lmmarise.seata.common.dto.AccountDto;
import org.lmmarise.seata.common.response.ObjectResponse;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/10/29 10:00 下午
 */
public interface IAccountService {
    ObjectResponse<?> decreaseAccount(AccountDto accountDto);
}

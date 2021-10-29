package org.lmmarise.seata.account.provider.service;

import lombok.extern.slf4j.Slf4j;
import org.lmmarise.seata.account.provider.repository.AccountRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/10/29 10:27 下午
 */
@Slf4j
@Service
public class AccountService {

    @Resource
    private AccountRepository accountRepository;

    public int decreaseAccount(String userId, double doubleValue) {
        return accountRepository.decreaseAccount(userId, doubleValue);
    }
}

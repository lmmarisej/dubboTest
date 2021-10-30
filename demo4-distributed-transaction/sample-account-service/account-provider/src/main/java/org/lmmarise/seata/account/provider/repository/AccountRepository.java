package org.lmmarise.seata.account.provider.repository;

import org.lmmarise.seata.account.provider.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.LockModeType;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/10/29 11:27 下午
 */
public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Modifying
    @Query("update Account a set a.balance = a.balance - ?2 where a.userId = ?1 and a.balance > 0")
    int decreaseAccount(String userId, double doubleValue);

    /**
     * 调用方法至少需要 @Transactional(isolation = Isolation.READ_COMMITTED)
     */
    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    @Query(value = "from Account a where a.userId = ?2")
    Account testGlobalLock(String userId);
}

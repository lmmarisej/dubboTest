package org.lmmarise.seata.repo.repository;

import org.lmmarise.seata.repo.entity.Repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/10/30 11:06 上午
 */
public interface RepoRepository extends JpaRepository<Repo, Integer> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update Repo r set r.count = r.count - ?2 where r.productCode = ?1 and r.count > 0")
    int decreaseRepo(String productCode, Integer count);
}

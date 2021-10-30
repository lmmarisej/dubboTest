package org.lmmarise.seata.repo.service;

import org.lmmarise.seata.repo.repository.RepoRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/10/30 11:11 上午
 */
@Service
public class RepoService {

    @Resource
    private RepoRepository repoRepository;

    public int decreaseRepo(String productCode, Integer count) {
        return repoRepository.decreaseRepo(productCode, count);
    }
}

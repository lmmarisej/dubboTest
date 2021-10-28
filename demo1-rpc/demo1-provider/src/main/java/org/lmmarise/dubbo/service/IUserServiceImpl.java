package org.lmmarise.dubbo.service;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/10/26 10:23 下午
 */
public class IUserServiceImpl implements IUserService {

    @Override
    public String getNameById(String uid) {
        System.out.println("receive request data:" + uid);
        return "cxk";
    }
}

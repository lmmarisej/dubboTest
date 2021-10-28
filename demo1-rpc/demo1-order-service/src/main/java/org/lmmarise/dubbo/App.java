package org.lmmarise.dubbo;

import org.lmmarise.dubbo.service.IUserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/10/26 11:27 下午
 */
public class App {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("classpath*:META-INF/spring/consumer.xml");
        IUserService iUserService = (IUserService) context.getBean("userService");
        System.out.println(iUserService.getNameById("1001"));
    }
}

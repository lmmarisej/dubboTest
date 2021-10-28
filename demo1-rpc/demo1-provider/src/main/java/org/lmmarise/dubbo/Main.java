package org.lmmarise.dubbo;

import org.apache.dubbo.common.compiler.Compiler;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.lmmarise.dubbo.spi.Driver;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/10/26 10:16 下午
 */
public class Main {

    public static void main(String[] args) throws IOException {
        dubboSpi();

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("classpath*:/META-INF/spring/user-provider.xml");
        context.start();
        Compiler compiler = ExtensionLoader.getExtensionLoader(Compiler.class).getAdaptiveExtension();
        System.out.println(compiler.getClass());
        System.in.read();
        org.apache.dubbo.container.Main.main(args);
    }

    /**
     * 测试dubbo的spi功能
     */
    public static void dubboSpi() {
        ExtensionLoader<Driver> extensionLoader = ExtensionLoader.getExtensionLoader(Driver.class);
        Driver driver = extensionLoader.getExtension("mysqlDriver");    // mysqlDriver 为 spi 文件中的 key
        System.out.println(driver.connect());
    }
}

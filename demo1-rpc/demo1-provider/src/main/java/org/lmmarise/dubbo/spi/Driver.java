package org.lmmarise.dubbo.spi;

import org.apache.dubbo.common.extension.SPI;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/10/26 10:15 下午
 */
@SPI
public interface Driver {
    String connect();
}

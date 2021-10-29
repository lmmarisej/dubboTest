package org.lmmarise.seata.common.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/10/29 10:00 下午
 */
@Data
public class ProductDto implements Serializable {
    private static final long serialVersionUID = 5842131055690625955L;
    private Integer id;
    private String productCode;
    private String name;
    private Integer count;
}

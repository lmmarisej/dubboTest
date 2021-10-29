package org.lmmarise.seata.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/10/29 10:00 下午
 */
@Data
public class OrderRequest implements Serializable{
    private static final long serialVersionUID = -4916456555673668661L;
    private String userId;
    private String productCode;
    private String name;
    private Integer count;
    private BigDecimal amount;
}

package org.lmmarise.seata.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/10/29 10:00 下午
 */
@Data
public class OrderDto implements Serializable {
    private static final long serialVersionUID = -1233077570826468556L;
    private String orderNo;
    private String userId;
    private String productCode;
    private Integer orderCount;
    private BigDecimal orderAmount;
}

package org.lmmarise.seata.common.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/10/29 10:02 下午
 */
@Getter
@Setter
public class AccountDto implements Serializable {
    private static final long serialVersionUID = 428434492100190769L;
    private Integer id;
    private String userId;
    private BigDecimal balance; // 分布式事物锁定资源
}

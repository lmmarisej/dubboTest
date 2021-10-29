package org.lmmarise.seata.order.entity;

import lombok.*;

import javax.persistence.*;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/10/29 11:18 下午
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String orderNo;
    private String userId;
    private String productCode;
    private Integer count;
    private Double amount;
}

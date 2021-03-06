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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String orderNo;
    private String userId;
    private String productCode;
    @Column(columnDefinition = "int(11) default 0")
    private Integer count;
    @Column(columnDefinition = "int(11) default 0")
    private Double amount;
}

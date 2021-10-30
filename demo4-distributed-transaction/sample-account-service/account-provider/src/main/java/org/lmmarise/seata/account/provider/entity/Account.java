package org.lmmarise.seata.account.provider.entity;

import lombok.*;

import javax.persistence.*;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/10/29 10:18 下午
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userId;
    @Column(nullable = false, columnDefinition = "int(11) default 0")
    private Double balance;
}

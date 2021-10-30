package org.lmmarise.seata.repo.entity;

import lombok.*;

import javax.persistence.*;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/10/30 11:03 上午
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_repo")
public class Repo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String productCode;
    private String name;
    @Column(columnDefinition = "int(11) default 0")
    private Integer count;
}

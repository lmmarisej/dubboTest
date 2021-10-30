package org.lmmarise.seata.repo.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Blob;
import java.sql.Date;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/10/30 12:15 下午
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "undo_log", uniqueConstraints = @UniqueConstraint(columnNames = {"xid", "branchId"}))
public class UndoLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, columnDefinition = "bigint(20)")
    private BigInteger branchId;
    @Column(nullable = false, columnDefinition = "varchar(100)")
    private String xid;
    @Column(nullable = false, columnDefinition = "varchar(128)")
    private String context;
    @Column(nullable = false)
    @Lob
    private Blob rollbackInfo;
    @Column(nullable = false, columnDefinition = "int(11)")
    private Integer logStatus;
    @CreatedDate
    private Date logCreated;
    @LastModifiedDate
    private Date logModified;
}

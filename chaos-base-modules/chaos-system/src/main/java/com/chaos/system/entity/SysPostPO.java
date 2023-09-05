package com.chaos.system.entity;

import com.chaos.common.core.entity.BasePO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;

/**
 * 岗位信息对应实体
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/23 15:26
 */
@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(name = "sys_post")
@DynamicUpdate
@DynamicInsert
@Where(clause = "is_deleted = 0")
public class SysPostPO extends BasePO {

  /** 岗位id */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /** 岗位编码 */
  @Column private String postCode;

  /** 岗位名称 */
  @Column private String postName;

  /** 显示顺序 */
  @Column private Integer sort;

  /** 状态（0正常 1停用） */
  @Column private Integer status;
}

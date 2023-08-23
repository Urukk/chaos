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

/**
 * 部门信息对应实体
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/23 15:17
 */
@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(name = "sys_dept")
@DynamicUpdate
@DynamicInsert
public class SysDeptPO extends BasePO {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /** 父部门id */
  @Column private Long parentId;

  /** 祖级列表 */
  @Column private String ancestors;

  /** 部门名称 */
  @Column private String deptName;

  /** 显示顺序 */
  @Column private Integer orderNum;
}

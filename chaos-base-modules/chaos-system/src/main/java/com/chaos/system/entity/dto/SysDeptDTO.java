package com.chaos.system.entity.dto;

import com.chaos.system.entity.bo.SysDeptBO;
import io.github.linpeilie.annotations.AutoMapper;
import java.io.Serial;
import java.io.Serializable;
import lombok.Data;

/**
 * dto层-部门信息
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/23 16:39
 */
@Data
@AutoMapper(target = SysDeptBO.class)
public class SysDeptDTO implements Serializable {

  @Serial private static final long serialVersionUID = 1L;

  /** 父部门id */
  private Long parentId;

  /** 祖级列表 */
  private String ancestors;

  /** 部门名称 */
  private String deptName;

  /** 显示顺序 */
  private Integer orderNum;
}

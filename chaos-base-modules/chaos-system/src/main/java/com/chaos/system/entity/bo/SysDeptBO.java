package com.chaos.system.entity.bo;

import com.chaos.common.core.entity.bo.BaseBO;
import com.chaos.system.entity.SysDeptPO;
import io.github.linpeilie.annotations.AutoMapper;
import java.io.Serial;
import java.io.Serializable;
import lombok.Data;

/**
 * bo层-部门信息
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/23 16:01
 */
@Data
@AutoMapper(target = SysDeptPO.class, reverseConvertGenerate = false)
public class SysDeptBO extends BaseBO implements Serializable {

  @Serial private static final long serialVersionUID = 1L;

  /** 部门id */
  private Long id;

  /** 父部门id */
  private Long parentId;

  /** 祖级列表 */
  private String ancestors;

  /** 部门名称 */
  private String deptName;

  /** 显示顺序 */
  private Integer orderNum;
}

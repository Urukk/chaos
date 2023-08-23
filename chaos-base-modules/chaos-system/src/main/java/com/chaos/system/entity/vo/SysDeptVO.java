package com.chaos.system.entity.vo;

import com.chaos.system.entity.SysDeptPO;
import com.chaos.system.entity.bo.SysDeptBO;
import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.AutoMappers;
import java.io.Serial;
import java.io.Serializable;
import lombok.Data;

/**
 * vo层-部门信息
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/23 16:31
 */
@Data
@AutoMappers({
  @AutoMapper(target = SysDeptPO.class),
  @AutoMapper(target = SysDeptBO.class, reverseConvertGenerate = false)
})
public class SysDeptVO implements Serializable {

  @Serial private static final long serialVersionUID = 1L;

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

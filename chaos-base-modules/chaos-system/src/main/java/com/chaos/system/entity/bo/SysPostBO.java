package com.chaos.system.entity.bo;

import com.chaos.common.core.entity.bo.BaseBO;
import com.chaos.system.entity.SysPostPO;
import io.github.linpeilie.annotations.AutoMapper;
import java.io.Serial;
import java.io.Serializable;
import lombok.Data;

/**
 * bo层-岗位信息
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/23 16:08
 */
@Data
@AutoMapper(target = SysPostPO.class)
public class SysPostBO extends BaseBO implements Serializable {

  @Serial private static final long serialVersionUID = 1L;

  /** 岗位id */
  private Long id;

  /** 岗位编码 */
  private String postCode;

  /** 岗位名称 */
  private String postName;

  /** 显示顺序 */
  private Integer sort;

  /** 状态（0正常 1停用） */
  private Integer status;
}

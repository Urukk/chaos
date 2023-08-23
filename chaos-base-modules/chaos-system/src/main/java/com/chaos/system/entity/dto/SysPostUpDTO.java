package com.chaos.system.entity.dto;

import com.chaos.system.entity.bo.SysPostBO;
import io.github.linpeilie.annotations.AutoMapper;
import java.io.Serial;
import java.io.Serializable;
import lombok.Data;

/**
 * dto层-岗位信息修改
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/23 16:44
 */
@Data
@AutoMapper(target = SysPostBO.class, reverseConvertGenerate = false)
public class SysPostUpDTO implements Serializable {

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

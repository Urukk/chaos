package com.chaos.system.entity.dto;

import com.chaos.system.entity.bo.SysPermissionBO;
import io.github.linpeilie.annotations.AutoMapper;
import java.io.Serial;
import java.io.Serializable;
import lombok.Data;

/**
 * dto层-权限信息修改
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/23 16:47
 */
@Data
@AutoMapper(target = SysPermissionBO.class, reverseConvertGenerate = false)
public class SysPermissionUpDTO implements Serializable {

  @Serial private static final long serialVersionUID = 1L;

  /** 权限id */
  private Long id;

  /** 权限名称 */
  private String permissionName;
}

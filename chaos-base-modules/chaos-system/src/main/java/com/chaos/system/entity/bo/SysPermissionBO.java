package com.chaos.system.entity.bo;

import com.chaos.common.core.entity.bo.BaseBO;
import com.chaos.system.entity.SysPermissionPO;
import io.github.linpeilie.annotations.AutoMapper;
import java.io.Serial;
import java.io.Serializable;
import lombok.Data;

/**
 * bo层-权限信息
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/23 16:12
 */
@Data
@AutoMapper(target = SysPermissionPO.class)
public class SysPermissionBO extends BaseBO implements Serializable {

  @Serial private static final long serialVersionUID = 1L;

  /** 权限id */
  private Long id;

  /** 权限名称 */
  private String permissionName;
}

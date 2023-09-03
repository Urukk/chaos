package com.chaos.system.entity.vo;

import com.chaos.system.entity.SysPermissionPO;
import com.chaos.system.entity.bo.SysPermissionBO;
import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.AutoMappers;
import java.io.Serial;
import java.io.Serializable;
import lombok.Data;

/**
 * vo层-权限信息
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/23 16:37
 */
@Data
@AutoMappers({
  @AutoMapper(target = SysPermissionPO.class),
  @AutoMapper(target = SysPermissionBO.class)
})
public class SysPermissionVO implements Serializable {

  @Serial private static final long serialVersionUID = 1L;

  /** 权限id */
  private Long id;

  /** 权限名称 */
  private String permissionName;
}

package com.chaos.system.entity.vo;

import com.chaos.system.entity.SysPermissionPO;
import com.chaos.system.entity.SysRolePO;
import com.chaos.system.entity.bo.SysRoleBO;
import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.AutoMappers;
import io.github.linpeilie.annotations.AutoMapping;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * vo层-角色信息
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/21 14:54
 */
@Data
@AutoMappers({@AutoMapper(target = SysRolePO.class), @AutoMapper(target = SysRoleBO.class)})
public class SysRoleVO implements Serializable {

  @Serial private static final long serialVersionUID = 1L;

  /** 角色id */
  private Long id;

  /** 角色名称 */
  private String roleName;

  /** 角色字符串 */
  private String roleKey;

  /** 角色排序 */
  private Integer roleSort;

  /** 权限信息集合 */
  @AutoMapping(targetClass = SysPermissionPO.class)
  private List<SysPermissionVO> permissions;
}

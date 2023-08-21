package com.chaos.system.entity.dto;

import com.chaos.system.entity.SysRolePO;
import io.github.linpeilie.annotations.AutoMapper;
import java.io.Serial;
import java.io.Serializable;
import lombok.Data;

/**
 * dto层-角色信息
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/21 14:51
 */
@Data
@AutoMapper(target = SysRolePO.class)
public class SysRoleDTO implements Serializable {

  @Serial private static final long serialVersionUID = 1L;

  /** 角色名称 */
  private String roleName;

  /** 角色字符串 */
  private String roleKey;

  /** 角色排序 */
  private Integer roleSort;
}

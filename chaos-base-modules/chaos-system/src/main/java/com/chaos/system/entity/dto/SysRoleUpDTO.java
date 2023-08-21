package com.chaos.system.entity.dto;

import com.chaos.system.entity.bo.SysRoleBO;
import io.github.linpeilie.annotations.AutoMapper;
import java.io.Serial;
import java.io.Serializable;
import lombok.Data;

/**
 * dto层-角色信息修改
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/21 14:51
 */
@Data
@AutoMapper(target = SysRoleBO.class)
public class SysRoleUpDTO implements Serializable {

  @Serial private static final long serialVersionUID = 1L;

  /** 用户id */
  private Long id;

  /** 角色名称 */
  private String roleName;

  /** 角色字符串 */
  private String roleKey;

  /** 角色排序 */
  private Integer roleSort;
}

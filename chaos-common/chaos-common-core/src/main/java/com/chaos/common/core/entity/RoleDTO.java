package com.chaos.common.core.entity;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录用户的角色信息
 *
 * @author S.H.I.E.L.D
 * @since 2023/09/08 16:11
 */
@Data
@NoArgsConstructor
public class RoleDTO {

  /** 角色ID */
  private Long id;

  /** 角色名称 */
  @Column private String roleName;

  /** 角色字符串 */
  @Column private String roleKey;

  /** 角色排序 */
  @Column private Integer roleSort;
}

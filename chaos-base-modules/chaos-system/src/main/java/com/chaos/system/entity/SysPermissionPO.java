package com.chaos.system.entity;

import com.chaos.common.core.entity.BasePO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.security.core.GrantedAuthority;

/**
 * 权限对应实体
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/23 15:29
 */
@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(name = "sys_permission")
@DynamicUpdate
@DynamicInsert
public class SysPermissionPO extends BasePO implements GrantedAuthority {

  /** 权限id */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /** 权限名称 */
  @Column private String permissionName;

  @ManyToMany(mappedBy = "permissions")
  @Exclude
  private List<SysRolePO> roles;

  @Override
  public String getAuthority() {
    return permissionName;
  }
}

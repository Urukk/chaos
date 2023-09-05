package com.chaos.system.entity;

import com.chaos.common.core.entity.BasePO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;

/**
 * 角色信息对应实体
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/21 14:30
 */
@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(name = "sys_role")
@DynamicInsert
@DynamicUpdate
@Where(clause = "is_deleted = 0")
public class SysRolePO extends BasePO {

  /** 角色id */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /** 角色名称 */
  @Column private String roleName;

  /** 角色字符串 */
  @Column private String roleKey;

  /** 角色排序 */
  @Column private Integer roleSort;

  @ManyToMany(mappedBy = "roles")
  @Exclude
  private List<SysUserPO> users;

  @ManyToMany
  @JoinTable(
      name = "sys_role_permission",
      joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "id"))
  @Exclude
  private List<SysPermissionPO> permissions;
}

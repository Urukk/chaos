package com.chaos.system.entity;

import com.chaos.common.core.entity.BasePO;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Transient;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Collection;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 用户信息对应实体类
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/05 12:56
 */
@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(name = "sys_user")
@DynamicUpdate
@DynamicInsert
public class SysUserPO extends BasePO implements UserDetails {

  /** 用户id */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /** 归属部门id */
  @Column(name = "dept_id")
  private Long deptId;

  /** 用户编号 */
  @Column(name = "user_no")
  private String userNo;

  /** 用户名 */
  @Column(name = "username")
  private String username;

  /** 用户密码 */
  @Column private String password;

  /** 性别(0-未知 1-男 2-女) */
  @Column private String gender;

  /** 头像地址 */
  @Column private String avatar;

  /** 身份证号 */
  @Column(name = "id_card")
  private String idCard;

  /** 手机号码 */
  @Column private String phone;

  /** 邮箱 */
  @Column private String email;

  /** 用户状态 0-正常 1-停用 */
  @Column private String status;

  /** 最后登录时间 */
  @Column(name = "last_login_time")
  private LocalDateTime lastLoginTime;

  /** 用户角色集合 */
  @ManyToMany
  @JoinTable(
      name = "sys_user_role",
      joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
  private List<SysRolePO> roles;

  /** 部门信息集合 */
  @ManyToMany
  @JoinTable(
      name = "sys_user_dept",
      joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "dept_id", referencedColumnName = "id"))
  private List<SysDeptPO> depts;

  @Transient private Collection<? extends GrantedAuthority> authorities;

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}

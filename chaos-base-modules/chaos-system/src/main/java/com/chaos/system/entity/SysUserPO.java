package com.chaos.system.entity;

import com.chaos.common.core.entity.BasePO;
import jakarta.persistence.Entity;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

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
public class SysUserPO extends BasePO {

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
  @Column(name = "user_name")
  private String userName;

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

}

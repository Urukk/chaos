package com.chaos.system.entity.vo;

import com.chaos.system.entity.SysDeptPO;
import com.chaos.system.entity.SysRolePO;
import com.chaos.system.entity.SysUserPO;
import com.chaos.system.entity.bo.SysUserBO;
import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.AutoMappers;
import io.github.linpeilie.annotations.AutoMapping;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

/**
 * vo层-用户信息
 *
 * @author S.H.I.E.L.D
 * @since 2023-08-20 0:53
 */
@Data
@AutoMappers({@AutoMapper(target = SysUserPO.class), @AutoMapper(target = SysUserBO.class)})
public class SysUserVO implements Serializable {

  @Serial private static final long serialVersionUID = 1L;

  /** 用户id */
  private Long id;

  /** 用户编号 */
  private String userNo;

  /** 用户名 */
  private String username;

  /** 用户密码 */
  private String password;

  /** 性别(0-未知 1-男 2-女) */
  private String gender;

  /** 头像地址 */
  private String avatar;

  /** 身份证号 */
  private String idCard;

  /** 手机号码 */
  private String phone;

  /** 邮箱 */
  private String email;

  /** 最后登录时间 */
  private LocalDateTime lastLoginTime;

  /** 角色信息集合 */
  @AutoMapping(targetClass = SysRolePO.class)
  private List<SysRoleVO> roles;

  /** 部门信息集合 */
  @AutoMapping(targetClass = SysDeptPO.class)
  private List<SysDeptVO> depts;
}

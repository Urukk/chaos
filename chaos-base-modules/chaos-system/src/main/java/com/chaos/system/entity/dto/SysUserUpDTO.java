package com.chaos.system.entity.dto;

import com.chaos.system.entity.bo.SysUserBO;
import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.NotBlank;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * dto层-用户信息修改
 *
 * @author S.H.I.E.L.D
 * @since 2023-08-20 0:29
 */
@Data
@AutoMapper(target = SysUserBO.class)
public class SysUserUpDTO implements Serializable {

  @Serial private static final long serialVersionUID = 1L;

  /** 主键 */
  private Long id;

  /** 用户名 */
  @NotBlank(message = "用户名不能为空")
  private String userName;

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
}

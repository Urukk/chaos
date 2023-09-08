package com.chaos.common.core.entity;

import com.chaos.common.core.xss.Xss;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * 登录用户信息
 *
 * @author S.H.I.E.L.D
 * @since 2023/09/08 13:12
 */
@Data
public class LoginBody {

  /** 用户账号 */
  @NotBlank(message = "用户账号不能为空")
  @Xss(message = "用户账号不能包含脚本字符")
  private String userNo;

  /** 用户名 */
  private String username;

  /** 密码 */
  @NotBlank(message = "密码不能为空")
  private String password;

  /** 验证码 */
  private String code;

  /** 唯一标识 */
  private String uuid = "";
}

package com.chaos.system.entity.dto;

import jakarta.validation.constraints.NotBlank;
import java.io.Serial;
import java.io.Serializable;
import lombok.Data;

/**
 * dto层-登录鉴权用户信息
 *
 * @author S.H.I.E.L.D
 * @since 2023/09/02 11:35
 */
@Data
public class SysAuthDTO implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  /** 用户编码 */
  @NotBlank(message = "账号不能为空")
  private String userNo;


  /** 用户密码 */
  @NotBlank(message = "用户密码不能为空")
  private String password;
}

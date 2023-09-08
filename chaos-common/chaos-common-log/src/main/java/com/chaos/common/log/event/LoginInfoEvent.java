package com.chaos.common.log.event;

import jakarta.servlet.http.HttpServletRequest;
import java.io.Serial;
import java.io.Serializable;
import lombok.Data;

/**
 * 登录事件
 *
 * @author S.H.I.E.L.D
 * @since 2023/09/08 11:11
 */
@Data
public class LoginInfoEvent implements Serializable {

  @Serial private static final long serialVersionUID = 1L;

  /** 用户账号 */
  private String username;

  /** 登录状态 0成功 1失败 */
  private String status;

  /** 提示消息 */
  private String message;

  /** 请求体 */
  private HttpServletRequest requestBody;

  /** 其他参数 */
  private Object[] args;
}

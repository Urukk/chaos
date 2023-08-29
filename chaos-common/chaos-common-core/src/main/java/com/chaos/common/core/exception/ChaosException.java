package com.chaos.common.core.exception;

import com.chaos.common.core.enums.BasicCode;

/**
 * 全局异常类
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/29 14:14
 */
public class ChaosException extends RuntimeException {

  private String code = "500";

  public ChaosException(BasicCode errorCode) {
    super(errorCode.getMessage());
    this.code = errorCode.getCode();
  }

  public ChaosException() {}

  public ChaosException(String message) {
    super(message);
  }

  public ChaosException(String message, Throwable cause) {
    super(message, cause);
  }

  public ChaosException(Throwable cause) {
    super(cause);
  }

  public ChaosException(
      String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public String getCode() {
    return code;
  }
}

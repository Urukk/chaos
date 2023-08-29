package com.chaos.common.core.advice;

import com.chaos.common.core.enums.BasicCode;
import com.chaos.common.core.exception.ChaosException;
import com.chaos.common.core.model.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一异常处理
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/29 14:59
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  @ExceptionHandler(ChaosException.class)
  public CommonResult<Void> handleChaosException(ChaosException e) {
    log.error("ChaosException: {}", e.getMessage());
    return CommonResult.fail(e.getCode(), e.getMessage());
  }

  @ExceptionHandler(Exception.class)
  public CommonResult<Void> handleException(Exception e) {
    log.error("Exception: {}", e.getMessage());
    return CommonResult.fail(BasicCode.UNKNOWN_ERROR.getCode(), e.getMessage());
  }
}

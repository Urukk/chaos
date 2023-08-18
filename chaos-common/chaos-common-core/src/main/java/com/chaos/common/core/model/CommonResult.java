package com.chaos.common.core.model;

import com.chaos.common.core.enums.BasicCode;
import com.chaos.common.core.enums.IMessage;
import com.chaos.common.core.utils.DateUtils;
import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

/**
 * 通用结果返回
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/18 16:24
 */
public class CommonResult<T> extends BaseResult implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;


  public CommonResult() {}

  public CommonResult(boolean success, String message) {
    this.setSuccess(success);
    this.setMessage(message);
  }

  public CommonResult(boolean success) {
    this.setSuccess(success);
  }

  public CommonResult(String code, String message) {
    this.setCode(code);
    this.setMessage(message);
  }

  public CommonResult(boolean success, String message, T data) {
    this.setSuccess(success);
    this.setMessage(message);
    this.setData(data);
  }

  public static CommonResult ok() {
    return ok(BasicCode.SUCCESS);
  }

  public static <T> CommonResult<T> ok(IMessage message) {
    return baseCreate(message.getCode(), message.getMessage(), true);
  }

  public static CommonResult fail() {
    return fail(BasicCode.UNKNOWN_ERROR);
  }

  public static CommonResult fail(IMessage message) {
    return fail(message.getCode(), message.getMessage());
  }

  public static CommonResult fail(String code, String message) {
    return baseCreate(code, message, false);
  }

  private static <T> CommonResult<T> baseCreate(String code, String msg, boolean success) {
    CommonResult<T> result = new CommonResult<>();
    result.setCode(code);
    result.setSuccess(success);
    result.setMessage(msg);
    result.setTimestamp(DateUtils.getDate());
    result.setTraceId(UUID.randomUUID().toString());
    return result;
  }

  public CommonResult<T> addTraceId(String traceId) {
    this.setTraceId(traceId);
    return this;
  }

  public CommonResult<T> setResult(T data) {
    this.setData(data);
    return this;
  }

  public CommonResult<T> addData(T data) {
    this.setData(data);
    return this;
  }

  public T getData() {
    return (T) super.getData();
  }

}

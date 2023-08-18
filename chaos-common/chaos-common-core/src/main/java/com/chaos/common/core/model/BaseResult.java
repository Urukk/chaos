package com.chaos.common.core.model;

import java.io.Serial;
import java.io.Serializable;
import lombok.Data;

/**
 * 结果返回基类
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/18 16:25
 */
@Data
public abstract class BaseResult<T> implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  /** 是否成功 */
  private boolean success = false;

  /** 响应信息 */
  private String message;

  /** 响应数据 */
  private T data;

  /** 响应码 */
  private String code;

  /** 时间戳 */
  private String timestamp;

  /** 请求ID */
  private String traceId;

  protected BaseResult() {}
}

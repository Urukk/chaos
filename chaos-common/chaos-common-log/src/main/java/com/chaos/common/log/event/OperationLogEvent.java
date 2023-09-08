package com.chaos.common.log.event;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 操作日志事件
 *
 * @author S.H.I.E.L.D
 * @since 2023/09/08 11:11
 */
@Data
public class OperationLogEvent implements Serializable {

  @Serial private static final long serialVersionUID = 1L;

  /** 日志主键 */
  private Long id;

  /** 操作模块 */
  private String title;

  /** 操作地址 */
  private String operationIp;

  /** 操作类型（0其它 1新增 2修改 3删除） */
  private Integer businessType;

  /** 操作类型数组 */
  private Integer[] businessTypes;

  /** 请求url */
  private String operationUrl;

  /** 请求方法 */
  private String operationMethod;

  /** 请求方式 */
  private String requestMethod;

  /** 请求参数 */
  private String requestParams;

  /** 响应内容 */
  private String responseContent;

  /** 操作人员 */
  private String operationName;

  /** 操作状态（0正常 1异常） */
  private Integer status;

  /** 错误消息 */
  private String errorMsg;

  /** 操作时间 */
  private LocalDateTime operationTime;

  /** 消耗时间 */
  private Long duration;
}

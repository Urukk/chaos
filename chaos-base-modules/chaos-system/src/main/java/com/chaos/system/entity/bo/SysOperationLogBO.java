package com.chaos.system.entity.bo;

import com.chaos.common.core.entity.bo.BaseBO;
import com.chaos.common.log.event.OperationLogEvent;
import com.chaos.system.entity.SysOperationLogPO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.AutoMappers;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * bo层-操作日志
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/23 16:10
 */
@Data
@AutoMappers({
  @AutoMapper(target = SysOperationLogPO.class),
  @AutoMapper(target = OperationLogEvent.class)
})
public class SysOperationLogBO extends BaseBO implements Serializable {

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
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime operationTime;

  /** 消耗时间 */
  private Long duration;
}

package com.chaos.system.entity.dto;

import com.chaos.system.entity.bo.SysOperationLogBO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.linpeilie.annotations.AutoMapper;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * dto层-操作日志
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/23 16:44
 */
@Data
@AutoMapper(target = SysOperationLogBO.class)
public class SysOperationLogDTO implements Serializable {

  @Serial private static final long serialVersionUID = 1L;

  /** IP地址 */
  private String operationIp;

  /** 操作类型(0其它 1新增 2修改 3删除) */
  private Integer operationType;

  /** 方法名 */
  private String operationMethod;

  /** 请求参数 */
  private String requestParams;

  /** 响应内容 */
  private String responseContent;

  /** 操作内容描述 */
  private String description;

  /** 操作用户名 */
  private String operationName;

  /** 操作时间 */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime operationTime;

  /** 消耗时间 */
  private Long duration;
}

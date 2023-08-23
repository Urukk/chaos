package com.chaos.system.entity;

import com.chaos.common.core.entity.BasePO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * 操作日志对应实体
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/23 15:32
 */
@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(name = "sys_operation_log")
@DynamicUpdate
@DynamicInsert
public class SysOperationLogPO extends BasePO {

  /** 日志主键 */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /** IP地址 */
  @Column private String operationIp;

  /** 操作类型(0其它 1新增 2修改 3删除) */
  @Column private Integer operationType;

  /** 方法名 */
  @Column private String operationMethod;

  /** 请求参数 */
  @Column private String requestParams;

  /** 响应内容 */
  @Column private String responseContent;

  /** 操作内容描述 */
  @Column private String description;

  /** 操作用户名 */
  @Column private String operationName;

  /** 操作时间 */
  @Column
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime operationTime;

  /** 消耗时间 */
  @Column private Long duration;
}

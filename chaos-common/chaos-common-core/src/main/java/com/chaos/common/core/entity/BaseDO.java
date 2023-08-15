package com.chaos.common.core.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.MappedSuperclass;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;

/**
 * DO基类
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/05 13:39
 */
@Getter
@Setter
@ToString
@MappedSuperclass
@DynamicInsert
public class BaseDO implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  /**
   * 逻辑删除的状态 0-未删除 1-已删除
   */
  @Column(name = "is_deleted", columnDefinition  = "tinyint default 0")
  private Integer isDeleted;

  /**
   * 创建者
   */
  @Column(name = "create_by", columnDefinition = "varchar(64) default ''")
  private String createBy;

  /**
   * 创建时间
   */
  @Column(name = "create_time", columnDefinition = "datetime default current_timestamp")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime createTime;

  /**
   * 更新者
   */
  @Column(name = "update_by", columnDefinition = "varchar(64) default ''")
  private String updateBy;

  /**
   * 更新时间
   */
  @Column(name = "update_time", columnDefinition = "datetime default current_timestamp")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime updateTime;

  /**
   * 备注
   */
  @Column
  private String remark;

}

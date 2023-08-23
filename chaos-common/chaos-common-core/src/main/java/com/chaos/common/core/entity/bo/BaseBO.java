package com.chaos.common.core.entity.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * BO基类
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/18 10:12
 */
@Data
public class BaseBO implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  /**
   * 逻辑删除的状态 0-未删除 1-已删除
   */
  private Integer isDeleted;

  /**
   * 创建者
   */
  private String createBy;

  /**
   * 创建时间
   */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime createTime;

  /**
   * 更新者
   */
  private String updateBy;

  /**
   * 更新时间
   */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime updateTime;

  /**
   * 备注
   */
  private String remark;

}

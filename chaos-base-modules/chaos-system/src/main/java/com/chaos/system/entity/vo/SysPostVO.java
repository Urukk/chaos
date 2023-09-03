package com.chaos.system.entity.vo;

import com.chaos.system.entity.SysPostPO;
import com.chaos.system.entity.bo.SysPostBO;
import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.AutoMappers;
import java.io.Serial;
import java.io.Serializable;
import lombok.Data;

/**
 * vo层-岗位信息
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/23 16:34
 */
@Data
@AutoMappers({
  @AutoMapper(target = SysPostPO.class),
  @AutoMapper(target = SysPostBO.class)
})
public class SysPostVO implements Serializable {

  @Serial private static final long serialVersionUID = 1L;

  /** 岗位id */
  private Long id;

  /** 岗位编码 */
  private String postCode;

  /** 岗位名称 */
  private String postName;

  /** 显示顺序 */
  private Integer sort;

  /** 状态（0正常 1停用） */
  private Integer status;
}

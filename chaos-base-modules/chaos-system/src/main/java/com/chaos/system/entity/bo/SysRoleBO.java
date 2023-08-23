package com.chaos.system.entity.bo;

import com.chaos.common.core.entity.bo.BaseBO;
import com.chaos.system.entity.SysRolePO;
import com.chaos.system.entity.SysUserPO;
import io.github.linpeilie.annotations.AutoMapper;
import java.io.Serial;
import java.io.Serializable;
import lombok.Data;

/**
 * bo层-角色信息
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/21 14:52
 */
@Data
@AutoMapper(target = SysRolePO.class, reverseConvertGenerate = false)
public class SysRoleBO extends BaseBO implements Serializable {

  @Serial private static final long serialVersionUID = 1L;

  /** 用户id */
  private Long id;

  /** 角色名称 */
  private String roleName;

  /** 角色字符串 */
  private String roleKey;

  /** 角色排序 */
  private Integer roleSort;
}

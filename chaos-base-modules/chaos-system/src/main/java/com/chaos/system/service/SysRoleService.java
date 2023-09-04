package com.chaos.system.service;

import com.chaos.common.core.service.BaseService;
import com.chaos.system.entity.SysRolePO;
import com.chaos.system.entity.bo.SysRoleBO;

/**
 * service层-角色管理
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/21 14:37
 */
public interface SysRoleService extends BaseService<SysRolePO> {

  /**
   * 保存角色信息
   *
   * @param bo 角色信息
   * @return {@link Boolean}
   */
  Boolean saveRole(SysRoleBO bo);

  /**
   * 更新角色信息
   *
   * @param bo 角色信息
   * @return {@link Boolean}
   */
  Boolean updateRole(SysRoleBO bo);
}

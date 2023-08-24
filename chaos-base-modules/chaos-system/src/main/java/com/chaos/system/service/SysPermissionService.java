package com.chaos.system.service;

import com.chaos.common.core.service.BaseService;
import com.chaos.system.entity.SysPermissionPO;
import com.chaos.system.entity.bo.SysPermissionBO;

/**
 * service层-权限管理
 *
 * @author S.H.I.E.L.D
 * @since 2023-08-23 23:57
 */
public interface SysPermissionService extends BaseService<SysPermissionPO> {

  /**
   * 保存权限信息
   *
   * @param bo 权限信息
   * @return {@link Boolean}
   */
  Boolean savePermission(SysPermissionBO bo);

  /**
   * 更新权限信息
   *
   * @param bo 权限信息
   * @return {@link Boolean}
   */
  Boolean updatePermission(SysPermissionBO bo);

}

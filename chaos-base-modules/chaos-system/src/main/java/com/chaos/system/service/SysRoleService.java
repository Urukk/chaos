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

  Boolean saveRole(SysRoleBO bo);

  Boolean updateRole(SysRoleBO bo);
}

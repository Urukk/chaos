package com.chaos.system.service;

import com.chaos.common.core.service.BaseService;
import com.chaos.system.entity.SysUserPO;
import com.chaos.system.entity.bo.SysUserBO;

/**
 * service层-用户信息
 *
 * @author S.H.I.E.L.D
 * @since 2023-08-14 21:26
 */
public interface UserService extends BaseService<SysUserPO> {

  Boolean saveUser(SysUserBO bo);

}

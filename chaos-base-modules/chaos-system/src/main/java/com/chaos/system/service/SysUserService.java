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
public interface SysUserService extends BaseService<SysUserPO> {

  /**
   * 保存用户信息
   *
   * @param bo 用户信息
   * @return {@link Boolean}
   */
  Boolean saveUser(SysUserBO bo);

  /**
   * 更新用户信息
   *
   * @param bo 用户信息
   * @return {@link Boolean}
   */
  Boolean updateUser(SysUserBO bo);

  /**
   * 根据用户名查询用户信息
   *
   * @param  phone 手机号
   * @return {@link SysUserPO}
   */
  SysUserPO findByPhone(String phone);
}

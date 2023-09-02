package com.chaos.system.service;

import com.chaos.system.entity.bo.SysUserBO;

/**
 * service层-鉴权
 *
 * @author S.H.I.E.L.D
 * @since 2023/09/02 11:41
 */
public interface SysAuthService {

  /**
   * 登录
   *
   * @param userNo 用户编号
   * @param password 用户密码
   */
  SysUserBO login(String userNo, String password);

}

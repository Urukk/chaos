package com.chaos.system.service;

import com.chaos.common.core.service.BaseService;
import com.chaos.system.entity.SysPostPO;
import com.chaos.system.entity.bo.SysPostBO;

/**
 * service层-岗位管理
 *
 * @author S.H.I.E.L.D
 * @since 2023-08-23 23:37
 */
public interface SysPostService extends BaseService<SysPostPO> {

  /**
   * 保存岗位信息
   *
   * @param bo 岗位信息
   * @return {@link Boolean}
   */
  Boolean savePost(SysPostBO bo);

  /**
   * 更新岗位信息
   *
   * @param bo 岗位信息
   * @return {@link Boolean}
   */
  Boolean updatePost(SysPostBO bo);

}

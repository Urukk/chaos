package com.chaos.system.service;

import com.chaos.common.core.service.BaseService;
import com.chaos.system.entity.SysDeptPO;
import com.chaos.system.entity.bo.SysDeptBO;

/**
 * service层-部门管理
 *
 * @author S.H.I.E.L.D
 * @since 2023-08-23 23:36
 */
public interface SysDeptService extends BaseService<SysDeptPO> {

  /**
   * 保存部门信息
   *
   * @param bo 部门信息
   * @return {@link Boolean}
   */
  Boolean saveDept(SysDeptBO bo);

  /**
   * 更新部门信息
   *
   * @param bo 部门信息
   * @return {@link Boolean}
   */
  Boolean updateDept(SysDeptBO bo);

}

package com.chaos.system.service;

import com.chaos.common.core.service.BaseService;
import com.chaos.system.entity.SysOperationLogPO;
import com.chaos.system.entity.bo.SysOperationLogBO;

/**
 * service层-操作日志
 *
 * @author S.H.I.E.L.D
 * @since 2023-08-23 23:54
 */
public interface SysOperationLogService extends BaseService<SysOperationLogPO> {

  /**
   * 保存操作日志信息
   *
   * @param bo 操作日志信息
   * @return {@link Boolean}
   */
  Boolean saveOperationLog(SysOperationLogBO bo);

  /**
   * 更新操作日志信息
   *
   * @param bo 操作日志信息
   * @return {@link Boolean}
   */
  Boolean updateOperationLog(SysOperationLogBO bo);
}

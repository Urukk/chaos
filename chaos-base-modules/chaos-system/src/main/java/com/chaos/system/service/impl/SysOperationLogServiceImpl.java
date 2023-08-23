package com.chaos.system.service.impl;

import com.chaos.common.core.service.impl.BaseServiceImpl;
import com.chaos.system.dao.SysOperationLogRepository;
import com.chaos.system.entity.SysOperationLogPO;
import com.chaos.system.service.SysOperationLogService;
import org.springframework.stereotype.Service;

/**
 * service层实现类-操作日志
 *
 * @author S.H.I.E.L.D
 * @since 2023-08-23 23:59
 */
@Service
public class SysOperationLogServiceImpl extends BaseServiceImpl<SysOperationLogRepository, SysOperationLogPO> implements
    SysOperationLogService {}

package com.chaos.system.dao;

import com.chaos.common.core.dao.BaseRepository;
import com.chaos.system.entity.SysOperationLogPO;
import org.springframework.stereotype.Repository;

/**
 * dao层-操作日志
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/23 15:56
 */
@Repository
public interface SysOperationLogRepository extends BaseRepository<SysOperationLogPO> {}

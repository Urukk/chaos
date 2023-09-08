package com.chaos.system.service.impl;

import com.chaos.common.core.service.impl.BaseServiceImpl;
import com.chaos.common.core.utils.MapStructUtils;
import com.chaos.common.log.event.OperationLogEvent;
import com.chaos.system.dao.SysOperationLogRepository;
import com.chaos.system.entity.SysOperationLogPO;
import com.chaos.system.entity.bo.SysOperationLogBO;
import com.chaos.system.service.SysOperationLogService;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * service层实现类-操作日志
 *
 * @author S.H.I.E.L.D
 * @since 2023-08-23 23:59
 */
@Service
public class SysOperationLogServiceImpl
    extends BaseServiceImpl<SysOperationLogRepository, SysOperationLogPO>
    implements SysOperationLogService {

  @Async
  @EventListener(OperationLogEvent.class)
  public void recordOperationLog(OperationLogEvent event) {
    SysOperationLogBO bo = MapStructUtils.convert(event, SysOperationLogBO.class);
    if (bo != null) {
      saveOperationLog(bo);
    }
  }

  @Override
  public Boolean saveOperationLog(SysOperationLogBO bo) {
    SysOperationLogPO po = MapStructUtils.convert(bo, SysOperationLogPO.class);
    if (po != null) {
      // TODO 业务逻辑 ...
      return super.save(po) != null;
    }
    return false;
  }

  @Override
  public Boolean updateOperationLog(SysOperationLogBO bo) {
    SysOperationLogPO po = MapStructUtils.convert(bo, SysOperationLogPO.class);
    if (po != null) {
      return super.save(po) != null;
    }
    return false;
  }
}

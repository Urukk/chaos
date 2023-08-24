package com.chaos.system.service.impl;

import com.chaos.common.core.service.impl.BaseServiceImpl;
import com.chaos.common.core.utils.MapStructUtils;
import com.chaos.system.dao.SysDeptRepository;
import com.chaos.system.entity.SysDeptPO;
import com.chaos.system.entity.bo.SysDeptBO;
import com.chaos.system.service.SysDeptService;
import org.springframework.stereotype.Service;

/**
 * service层实现类-部门管理
 *
 * @author S.H.I.E.L.D
 * @since 2023-08-23 23:57
 */
@Service
public class SysDeptServiceImpl extends BaseServiceImpl<SysDeptRepository, SysDeptPO>
    implements SysDeptService {

  @Override
  public Boolean saveDept(SysDeptBO bo) {
    SysDeptPO po = MapStructUtils.convert(bo, SysDeptPO.class);
    if (po != null) {
      // TODO 业务逻辑 ...
      return super.save(po) != null;
    }
    return false;
  }

  @Override
  public Boolean updateDept(SysDeptBO bo) {
    SysDeptPO po = MapStructUtils.convert(bo, SysDeptPO.class);
    if (po != null) {
      return super.save(po) != null;
    }
    return false;
  }
}

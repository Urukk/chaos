package com.chaos.system.service.impl;

import com.chaos.common.core.service.impl.BaseServiceImpl;
import com.chaos.common.core.utils.MapStructUtils;
import com.chaos.system.dao.SysPermissionRepository;
import com.chaos.system.entity.SysPermissionPO;
import com.chaos.system.entity.bo.SysPermissionBO;
import com.chaos.system.service.SysPermissionService;
import org.springframework.stereotype.Service;

/**
 * service层实现类-权限管理
 *
 * @author S.H.I.E.L.D
 * @since 2023-08-24 0:01
 */
@Service
public class SysPermissionServiceImpl
    extends BaseServiceImpl<SysPermissionRepository, SysPermissionPO>
    implements SysPermissionService {

  @Override
  public Boolean savePermission(SysPermissionBO bo) {
    SysPermissionPO po = MapStructUtils.convert(bo, SysPermissionPO.class);
    if (po != null) {
      // TODO 业务逻辑 ...
      return super.save(po) != null;
    }
    return false;
  }

  @Override
  public Boolean updatePermission(SysPermissionBO bo) {
    SysPermissionPO po = MapStructUtils.convert(bo, SysPermissionPO.class);
    if (po != null) {
      return super.save(po) != null;
    }
    return false;
  }
}

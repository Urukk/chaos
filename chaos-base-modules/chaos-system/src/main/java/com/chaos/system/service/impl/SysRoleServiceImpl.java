package com.chaos.system.service.impl;

import com.chaos.common.core.service.impl.BaseServiceImpl;
import com.chaos.common.core.utils.MapStructUtils;
import com.chaos.system.dao.SysRoleDao;
import com.chaos.system.entity.SysRolePO;
import com.chaos.system.entity.bo.SysRoleBO;
import com.chaos.system.service.SysRoleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * service实现类-角色管理
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/21 14:38
 */
@Service
public class SysRoleServiceImpl extends BaseServiceImpl<SysRoleDao, SysRolePO>
    implements SysRoleService {

  @Override
  public Boolean saveRole(SysRoleBO bo) {
    SysRolePO po = MapStructUtils.convert(bo, SysRolePO.class);
    if (po != null) {
      // TODO 业务逻辑 ...获取用户名等等
      return super.save(po) != null;
    }
    return false;
  }

  @Override
  public Boolean updateRole(SysRoleBO bo) {
    SysRolePO po = MapStructUtils.convert(bo, SysRolePO.class);
    if (po != null) {
      return super.save(po) != null;
    }
    return false;
  }
}

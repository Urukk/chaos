package com.chaos.system.service.impl;

import com.chaos.common.core.service.impl.BaseServiceImpl;
import com.chaos.common.core.utils.MapStructUtils;
import com.chaos.system.dao.SysUserDao;
import com.chaos.system.entity.SysUserPO;
import com.chaos.system.entity.bo.SysUserBO;
import com.chaos.system.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * service实现类-用户信息
 *
 * @author S.H.I.E.L.D
 * @since 2023-08-14 21:30
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<SysUserDao, SysUserPO> implements UserService {

  @Resource private SysUserDao sysUserDao;

  @Override
  public Boolean saveUser(SysUserBO bo) {
    SysUserPO po = MapStructUtils.convert(bo, SysUserPO.class);
    if (po != null) {
      // TODO 业务逻辑 ...初始化用户密码等等
      po.setPassword("123456");
      return super.save(po) != null;
    }
    return false;
  }
}

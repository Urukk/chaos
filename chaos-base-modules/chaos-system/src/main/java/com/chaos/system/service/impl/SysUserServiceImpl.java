package com.chaos.system.service.impl;

import com.chaos.common.core.service.impl.BaseServiceImpl;
import com.chaos.common.core.utils.MapStructUtils;
import com.chaos.system.dao.SysUserRepository;
import com.chaos.system.entity.SysUserPO;
import com.chaos.system.entity.bo.SysUserBO;
import com.chaos.system.service.SysUserService;
import jakarta.annotation.Resource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * service实现类-用户信息
 *
 * @author S.H.I.E.L.D
 * @since 2023-08-14 21:30
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUserRepository, SysUserPO>
    implements SysUserService {

  @Resource private BCryptPasswordEncoder encoder;

  @Resource
  private SysUserRepository userRepository;

  @Override
  public Boolean saveUser(SysUserBO bo) {
    SysUserPO po = MapStructUtils.convert(bo, SysUserPO.class);
    if (po != null) {
      // 初始化用户密码
      po.setPassword(encoder.encode(bo.getPassword()));
      return super.save(po) != null;
    }
    return false;
  }

  @Override
  public Boolean updateUser(SysUserBO bo) {
    SysUserPO po = MapStructUtils.convert(bo, SysUserPO.class);
    if (po != null) {
      return super.save(po) != null;
    }
    return false;
  }

  @Override
  @Transactional(readOnly = true)
  public SysUserBO findByPhone(String phone) {
    SysUserPO po = userRepository.findByPhone(phone);
    return MapStructUtils.convert(po, SysUserBO.class);
  }
}

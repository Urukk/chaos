package com.chaos.system.service.demo.impl;

import com.chaos.system.dao.SysUserDao;
import com.chaos.system.entity.SysUserPO;
import com.chaos.system.service.demo.DemoService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * service层-demo实现类
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/15 12:57
 */
@Service
public class DemoServiceImpl implements DemoService {

  @Resource
  private SysUserDao sysUserDao;

  @Override
  public SysUserPO getById(Long id) {
    return sysUserDao.findById(id).orElse(null);
  }
}

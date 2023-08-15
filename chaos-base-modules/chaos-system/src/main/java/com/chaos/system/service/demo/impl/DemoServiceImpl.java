package com.chaos.system.service.demo.impl;

import com.chaos.system.dao.UserDao;
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
  private UserDao userDao;

  @Override
  public com.chaos.system.entity.UserPO getById(Long id) {
    return userDao.findById(id).orElse(null);
  }
}

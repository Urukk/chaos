package com.chaos.system.service.impl;

import com.chaos.common.core.enums.BasicCode;
import com.chaos.common.core.exception.ChaosException;
import com.chaos.common.core.utils.MapStructUtils;
import com.chaos.system.dao.SysUserRepository;
import com.chaos.system.entity.SysUserPO;
import com.chaos.system.entity.bo.SysUserBO;
import com.chaos.system.service.SysAuthService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

/**
 * service层实现类-鉴权
 *
 * @author S.H.I.E.L.D
 * @since 2023/09/02 11:42
 */
@Service
@Slf4j
public class SysAuthServiceImpl implements SysAuthService {

  @Resource private AuthenticationManager authenticationManager;

  @Resource private SysUserRepository userRepository;

  @Override
  public SysUserPO login(String userNo, String password) {
    SysUserPO user = userRepository.findByUserNo(userNo);
    if (user == null) {
      throw new ChaosException(BasicCode.ERROR_LOGIN);
    }
    UsernamePasswordAuthenticationToken token =
        new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
    try {
      authenticationManager.authenticate(token);
      return user;
    } catch (Exception e) {
      log.error("登录失败", e);
      throw new ChaosException(BasicCode.ERROR_LOGIN);
    }
  }
}

package com.chaos.system.service.impl;

import com.chaos.system.dao.SysUserRepository;
import com.chaos.system.entity.SysPermissionPO;
import com.chaos.system.entity.SysRolePO;
import com.chaos.system.entity.SysUserPO;
import jakarta.annotation.Resource;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * security 实现用户详细信息impl
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/29 10:29
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Resource private SysUserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    SysUserPO user = userRepository.findByUserName(userName);
    List<SysRolePO> roles = user.getRoles();
    List<SysPermissionPO> permissions =
        roles.stream().flatMap(role -> role.getPermissions().stream()).distinct().toList();
    user.setAuthorities(permissions);
    return user;
  }
}

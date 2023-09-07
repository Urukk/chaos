package com.chaos.common.security.utils;

import com.chaos.common.core.entity.LoginUser;
import java.util.Optional;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 安全工具类
 *
 * @author S.H.I.E.L.D
 * @since 2023/09/07 14:28
 */
public final class SecurityUtils {

  private SecurityUtils() {}

  /**
   * 获取当前登录用户
   *
   * @return 用户信息
   */
  public static Optional<LoginUser> getLoginUser() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication != null && authentication.getPrincipal() instanceof LoginUser) {
      return Optional.of((LoginUser) authentication.getPrincipal());
    }
    return Optional.empty();
  }

  /**
   * 获取当前登录用户
   *
   * @return 用户信息
   */
  public static String getLoginUsername() {
    return getLoginUser().map(LoginUser::getUsername).orElse(null);
  }
}

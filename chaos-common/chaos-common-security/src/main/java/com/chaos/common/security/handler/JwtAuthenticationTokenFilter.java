package com.chaos.common.security.handler;

import com.chaos.common.core.enums.BasicCode;
import com.chaos.common.core.exception.ChaosException;
import com.chaos.common.security.config.SecurityIgnoreUrl;
import com.chaos.common.security.utils.JwtUtils;
import jakarta.annotation.Resource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * JWT校验过滤器
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/28 16:44
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

  public static final String AUTHORIZATION = "Authorization";

  @Resource private UserDetailsService userDetailsService;

  @Resource private SecurityIgnoreUrl securityIgnoreUrl;

  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {

    // 从请求头获取到token
    String token = request.getHeader(AUTHORIZATION);

    Stream<RequestMatcher> matchers =
        Arrays.stream(securityIgnoreUrl.getUrls()).map(AntPathRequestMatcher::new);
    if (matchers.anyMatch(matcher -> matcher.matches(request))) {
      filterChain.doFilter(request, response);
      return;
    }

    // 根据token状态进行判断返回
    if (token == null) {
      throw new ChaosException(BasicCode.TOKEN_IS_EMPTY);
    }

    if (JwtUtils.verify(token) && JwtUtils.isExpired(token)) {
      throw new ChaosException(BasicCode.TOKEN_IS_EXPIRED);
    }

    if (JwtUtils.verify(token)) {
      throw new ChaosException(BasicCode.TOKEN_IS_ILLEGAL);
    }

    String username = JwtUtils.getUsername(token);
    UserDetails userDetails = userDetailsService.loadUserByUsername(username);
    UsernamePasswordAuthenticationToken authenticationToken =
        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    SecurityContextHolder.getContext().setAuthentication(authenticationToken);

    filterChain.doFilter(request, response);
  }
}

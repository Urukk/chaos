package com.chaos.common.security.handler;

import jakarta.annotation.Resource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

/**
 * 异常处理过滤器
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/28 16:46
 */
@Component
public class ExceptionHandlerFilter extends OncePerRequestFilter {

  @Resource(name = "handlerExceptionResolver")
  private HandlerExceptionResolver resolver;

  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    try {
      filterChain.doFilter(request, response);
    } catch (Exception e) {
      resolver.resolveException(request, response, null, e);
    }
  }
}

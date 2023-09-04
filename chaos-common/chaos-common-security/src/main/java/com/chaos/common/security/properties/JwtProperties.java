package com.chaos.common.security.properties;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

/**
 * JWT配置
 *
 * @author S.H.I.E.L.D
 * @since 2023/09/04 16:29
 */
@Data
@Slf4j
public class JwtProperties {

  /** 密钥 */
  @Value("${auth.jwt.secret}")
  private String secret;

  /** 过期时间 */
  @Value("${auth.jwt.expiration}")
  private Long expiration;

}

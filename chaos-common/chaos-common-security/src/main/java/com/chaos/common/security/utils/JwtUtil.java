package com.chaos.common.security.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * jwt 工具类
 *
 * @author S.H.I.E.L.D
 * @since 2023/09/05 09:01
 */
@Component
@Data
@Slf4j
@ConfigurationProperties(prefix = "auth.jwt")
public class JwtUtil {

  /** 密钥 */
  private String secret;

  /** 过期时间 */
  private Long expiration;

  /**
   * 生成 token
   *
   * @param userNo 用户编号
   * @param username 用户名
   * @return token
   */
  public String generateToken(String userNo, String username) {
    log.info("secret:{}", secret);
    return JWT.create()
        .withClaim("userNo", userNo)
        .withClaim("username", username)
        .withExpiresAt(Instant.now().plus(1, ChronoUnit.DAYS))
        .sign(Algorithm.HMAC256(secret));
  }

  /**
   * 获取用户名
   *
   * @param token token
   * @return 用户名
   */
  public String getUsername(String token) {
    return JWT.decode(token).getClaim("username").asString();
  }

  /**
   * 获取用户编号
   *
   * @param token token
   * @return 用户 id
   */
  public Long getUserNo(String token) {
    return JWT.decode(token).getClaim("userNo").asLong();
  }

  /**
   * 验证 token
   *
   * @param token token
   * @return 是否合法
   */
  public boolean verify(String token) {
    try {
      JWT.require(Algorithm.HMAC256(secret)).build().verify(token);
      return true;
    } catch (JWTVerificationException | IllegalArgumentException e) {
      return false;
    }
  }

  /**
   * 判断 token 是否过期
   *
   * @param token token
   * @return 是否过期
   */
  public boolean isExpired(String token) {
    return JWT.decode(token).getExpiresAt().before(new Date());
  }
}

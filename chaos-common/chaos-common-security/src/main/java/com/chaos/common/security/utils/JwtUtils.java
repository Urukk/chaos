package com.chaos.common.security.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

/**
 * jwt 工具类
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/28 13:08
 */
@Slf4j
public final class JwtUtils {

  private JwtUtils() {}

  /** 密钥 */
  @Value("${auth.jwt.secret}")
  private static String secret;

  /** 签发者 */
  @Value("${auth.jwt.expiration}")
  private Long expiration;

  /**
   * 生成 token
   *
   * @param userNo 用户编号
   * @param username 用户名
   * @return token
   */
  public static String generateToken(String userNo, String username) {
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
  public static String getUsername(String token) {
    return JWT.decode(token).getClaim("username").asString();
  }

  /**
   * 获取用户编号
   *
   * @param token token
   * @return 用户 id
   */
  public static Long getUserNo(String token) {
    return JWT.decode(token).getClaim("userNo").asLong();
  }

  /**
   * 验证 token
   *
   * @param token token
   * @return 是否合法
   */
  public static boolean verify(String token) {
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
  public static boolean isExpired(String token) {
    return JWT.decode(token).getExpiresAt().before(new Date());
  }
}

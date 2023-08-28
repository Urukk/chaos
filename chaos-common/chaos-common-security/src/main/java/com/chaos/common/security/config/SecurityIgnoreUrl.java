package com.chaos.common.security.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * security 白名单
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/28 11:10
 */
@ConfigurationProperties(prefix = "security.ignore")
@Component
@Data
public class SecurityIgnoreUrl {

  String[] urls;
}

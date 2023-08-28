package com.chaos.common.security.config;

import static org.springframework.security.config.Customizer.withDefaults;

import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * security 配置
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/28 10:59
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig {

  @Resource private SecurityIgnoreUrl securityIgnoreUrl;

  @Bean
  SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(
            authorize ->
                authorize
                    .requestMatchers(securityIgnoreUrl.getUrls())
                    .permitAll()
                    .anyRequest()
                    .authenticated())
        .httpBasic(withDefaults());

    return http.build();
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
    return http.getSharedObject(AuthenticationManagerBuilder.class).build();
  }
}

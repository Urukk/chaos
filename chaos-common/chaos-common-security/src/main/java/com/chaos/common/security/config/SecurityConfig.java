package com.chaos.common.security.config;

import static org.springframework.security.config.Customizer.withDefaults;

import com.chaos.common.security.handler.ExceptionHandlerFilter;
import com.chaos.common.security.handler.JwtAuthenticationTokenFilter;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;

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

  @Resource private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

  @Resource private ExceptionHandlerFilter exceptionHandlerFilter;

  @Bean
  SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests(
            authorize ->
                authorize
                    .requestMatchers(securityIgnoreUrl.getUrls())
                    .permitAll()
                    .anyRequest()
                    .authenticated())
        .httpBasic(withDefaults());
    http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class)
        .addFilterBefore(exceptionHandlerFilter, LogoutFilter.class);
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

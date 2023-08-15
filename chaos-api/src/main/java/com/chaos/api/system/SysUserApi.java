package com.chaos.api.system;

import com.chaos.system.service.UserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 基础模块-用户信息
 *
 * @author S.H.I.E.L.D
 * @since 2023-08-14 21:39
 */
@RestController
@RequestMapping("/api/v1/user")
@Slf4j
public class SysUserApi {

  @Resource
  private UserService userService;

  @GetMapping("/{id}")
  public Object getById(@PathVariable Long id) {
    log.info("查询用户信息, id:{}", id);
    return userService.findById(id);
  }

}

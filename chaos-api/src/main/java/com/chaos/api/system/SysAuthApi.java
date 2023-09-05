package com.chaos.api.system;

import com.chaos.common.core.model.CommonResult;
import com.chaos.common.security.utils.JwtUtil;
import com.chaos.system.entity.SysUserPO;
import com.chaos.system.entity.dto.SysAuthDTO;
import com.chaos.system.service.SysAuthService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 基础模块-登录鉴权
 *
 * @author S.H.I.E.L.D
 * @since 2023/09/02 11:33
 */
@RestController
@RequestMapping("/api/v1/auth")
@Slf4j
public class SysAuthApi {

  @Resource private SysAuthService authService;

  @Resource private JwtUtil jwtUtil;
  /**
   * 登录
   *
   * @param dto 登录信息
   * @return 是否登录成功
   */
  @PostMapping("/login")
  public CommonResult<String> login(@RequestBody SysAuthDTO dto) {
    log.info("登录");
    SysUserPO po = authService.login(dto.getUserNo(), dto.getPassword());
    String token = jwtUtil.generateToken(po.getUserNo(), po.getUsername());
    return CommonResult.ok().setResult(token);
  }
}

package com.chaos.api.demo;

import com.chaos.system.service.demo.DemoService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试demo
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/15 13:00
 */
@RestController
@RequestMapping("/api/v1/demo")
@Slf4j
public class DemoApi {

  @Resource
  private DemoService demoService;

  /**
   * 查询测试接口
   *
   * @param id 用户id
   * @return {@link Object}
   */
  @GetMapping("/{id}")
  @ResponseBody
  public Object getById(@PathVariable Long id) {
    log.info("查询用户信息, id:{}", id);
    return demoService.getById(id);
  }
}

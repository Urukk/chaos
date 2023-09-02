package service;

import com.chaos.ChaosApplication;
import com.chaos.system.entity.SysUserPO;
import com.chaos.system.entity.bo.SysUserBO;
import com.chaos.system.service.SysAuthService;
import com.chaos.system.service.SysUserService;
import jakarta.annotation.Resource;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * service层-用户信息 测试类
 *
 * @author S.H.I.E.L.D
 * @since 2023-08-14 21:32
 */
@SpringBootTest(classes = ChaosApplication.class)
@ExtendWith(SpringExtension.class)
class SysUserServiceTest {

  @Resource
  private SysUserService sysUserService;

  @Resource
  private SysAuthService authService;

  @Test
  void getById() {
    System.out.println(sysUserService.findById(1L));
  }

  @Test
  void saveUser() {

    SysUserBO user = new SysUserBO();
    user.setUserName("孙八");
    user.setPassword("1234567");
    user.setIdCard("110110200001010001");
    user.setEmail("0000@163.com");
    user.setPhone("13333333333");
    user.setLastLoginTime(LocalDateTime.now());

    System.out.println(sysUserService.saveUser(user));
  }

  @Test
  void login() {
    SysUserBO bo = authService.login("sunba", "1234567");
    System.out.println(bo.getId());
  }
}

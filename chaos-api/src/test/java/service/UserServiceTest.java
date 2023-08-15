package service;

import com.chaos.ChaosApplication;
import com.chaos.system.service.UserService;
import jakarta.annotation.Resource;
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
class UserServiceTest {

  @Resource
  private UserService userService;

  @Test
  void getById() {
    System.out.println(userService.findById(1L));
  }
}

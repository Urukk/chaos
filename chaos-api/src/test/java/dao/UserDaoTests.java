package dao;

import com.chaos.ChaosApplication;
import com.chaos.system.dao.UserDao;
import com.chaos.system.entity.UserDO;
import jakarta.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * 用户信息测试类
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/05 14:24
 */

@SpringBootTest(classes = ChaosApplication.class)
@ExtendWith(SpringExtension.class)
class UserDaoTests {

  @Resource
  private UserDao userDao;

  @Test
  void save() {
    UserDO user = new UserDO();
    user.setUserName("demo");
    user.setPassword("demo");
    userDao.save(user);
  }

  @Test
  void findById() {
    Optional<UserDO> user = userDao.findById(1L);
    user.ifPresent(userDO -> {
      System.out.println(userDO.getUpdateTime().toString());
      System.out.println(userDO);
    });
  }

  @Test
  void updateById() {
    userDao
        .findById(1L)
        .ifPresent(
            user -> {
              user.setUserName("test1");
              user.setUpdateTime(LocalDateTime.now());
              UserDO uDo = userDao.save(user);
              System.out.println(uDo);
            });
  }

  @Test
  void logicDeleteById() {
    userDao.logicDeleteById(1L);
    Assertions.assertTrue(userDao.findById(1L).isEmpty());
  }

  @Test
  void deleteById() {
    userDao.deleteById(1L);
    Assertions.assertTrue(userDao.findById(1L).isEmpty());
  }

}

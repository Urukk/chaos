package dao;

import com.chaos.ChaosApplication;
import com.chaos.system.dao.SysUserDao;
import com.chaos.system.entity.SysUserPO;
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
class SysUserDaoTests {

  @Resource
  private SysUserDao sysUserDao;

  @Test
  void save() {
    SysUserPO user = new SysUserPO();
    user.setUserName("demo");
    user.setPassword("demo");
    sysUserDao.save(user);
  }

  @Test
  void findById() {
    Optional<SysUserPO> user = sysUserDao.findById(1L);
    user.ifPresent(po -> {
      System.out.println(po.getUpdateTime().toString());
      System.out.println(po);
    });
  }

  @Test
  void updateById() {
    sysUserDao
        .findById(1L)
        .ifPresent(
            user -> {
              user.setUserName("test1");
              user.setUpdateTime(LocalDateTime.now());
              SysUserPO sysUserPO = sysUserDao.save(user);
              System.out.println(sysUserPO);
            });
  }

  @Test
  void logicDeleteById() {
    sysUserDao.logicDeleteById(1L);
    Assertions.assertTrue(sysUserDao.findById(1L).isEmpty());
  }

  @Test
  void deleteById() {
    sysUserDao.deleteById(1L);
    Assertions.assertTrue(sysUserDao.findById(1L).isEmpty());
  }

}

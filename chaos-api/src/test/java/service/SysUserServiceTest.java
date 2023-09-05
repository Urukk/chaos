package service;

import com.chaos.ChaosApplication;
import com.chaos.system.entity.SysDeptPO;
import com.chaos.system.entity.SysPermissionPO;
import com.chaos.system.entity.SysRolePO;
import com.chaos.system.entity.SysUserPO;
import com.chaos.system.entity.bo.SysDeptBO;
import com.chaos.system.entity.bo.SysPermissionBO;
import com.chaos.system.entity.bo.SysRoleBO;
import com.chaos.system.entity.bo.SysUserBO;
import com.chaos.system.service.SysAuthService;
import com.chaos.system.service.SysDeptService;
import com.chaos.system.service.SysPermissionService;
import com.chaos.system.service.SysRoleService;
import com.chaos.system.service.SysUserService;
import jakarta.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

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

  @Resource
  private SysRoleService roleService;

  @Resource
  private SysDeptService deptService;

  @Resource
  private SysPermissionService permissionService;

  @Test
  @Transactional(readOnly = true)
  void getById() {
    System.out.println(sysUserService.findById(1L));
  }

  @Test
  void saveUser() {

    SysUserBO user = new SysUserBO();
    user.setUsername("周九");
    user.setUserNo("zhoujiu");
    user.setPassword("1234567");
    user.setIdCard("110110200001010001");
    user.setEmail("0000@163.com");
    user.setPhone("13333333333");
    user.setLastLoginTime(LocalDateTime.now());
    SysRolePO po = roleService.findById(2L);
    user.setRoles(Collections.singletonList(po));
//    SysDeptPO deptPO = deptService.findById(1L);
//    user.setDepts(Collections.singletonList(deptPO));

    System.out.println(sysUserService.saveUser(user));
  }

  @Test
  void login() {
    SysUserPO bo = authService.login("sunba", "1234567");
    System.out.println(bo.getId());
  }

  @Test
  void saveRole(){
    SysRoleBO bo = new SysRoleBO();
    bo.setRoleName("员工");
    bo.setRoleKey("common");
    bo.setRoleSort(2);
    SysPermissionPO po = permissionService.findById(1L);
    bo.setPermissions(Collections.singletonList(po));
    roleService.saveRole(bo);
  }

  @Test
  void saveDept(){
    SysDeptBO bo = new SysDeptBO();
    bo.setDeptName("总部");
    bo.setAncestors("0");
    bo.setOrderNum(1);
    bo.setParentId(0L);
    deptService.saveDept(bo);
  }

  @Test
  void savePermission(){
    SysPermissionBO bo = new SysPermissionBO();
    bo.setPermissionName("system:user");
    permissionService.savePermission(bo);
  }

  @Test
  @Transactional(readOnly = true)
  void findByPhone(){
    SysUserPO po = sysUserService.findByPhone("13333333334");
    System.out.println(po);
  }
}

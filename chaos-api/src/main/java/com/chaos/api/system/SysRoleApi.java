package com.chaos.api.system;

import com.chaos.common.core.enums.BasicCode;
import com.chaos.common.core.model.CommonResult;
import com.chaos.common.core.utils.MapStructUtils;
import com.chaos.system.entity.SysRolePO;
import com.chaos.system.entity.bo.SysRoleBO;
import com.chaos.system.entity.dto.SysRoleDTO;
import com.chaos.system.entity.dto.SysRoleUpDTO;
import com.chaos.system.entity.vo.SysRoleVO;
import com.chaos.system.service.SysRoleService;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.NotNull;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 基础模块-角色管理
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/21 14:28
 */
@RestController
@RequestMapping("/api/v1/role")
@Slf4j
public class SysRoleApi {

  @Resource private SysRoleService sysRoleService;

  /**
   * 保存角色信息
   *
   * @param dto 角色信息
   * @return {@link CommonResult <Boolean>}
   */
  @PostMapping("/save")
  public CommonResult<Boolean> save(@RequestBody SysRoleDTO dto) {
    log.info("新增角色信息");
    SysRoleBO bo = MapStructUtils.convert(dto, SysRoleBO.class);
    Boolean result = sysRoleService.saveRole(bo);
    log.info("新增角色信息是否成功, result:{}", result);
    return result ? CommonResult.fail(BasicCode.INSERT_ERROR) : CommonResult.ok(BasicCode.SUCCESS);
  }

  /**
   * 删除角色信息
   *
   * @param ids 角色id数组
   * @return {@link CommonResult<Boolean>}
   */
  @DeleteMapping("/{ids}")
  public CommonResult<Boolean> deleteById(@PathVariable @NotNull Long[] ids) {
    Boolean result = false;
    if (ids.length > 0) {
      log.info("删除角色信息, id:{}", Arrays.toString(ids));
      result = sysRoleService.batchDeleteById(Arrays.asList(ids));
      log.info("删除角色信息是否成功, result:{}", result);
    }
    return result ? CommonResult.fail(BasicCode.DELETE_ERROR) : CommonResult.ok(BasicCode.SUCCESS);
  }

  /**
   * 更新角色信息
   *
   * @param dto 角色信息
   * @return {@link CommonResult<Boolean>}
   */
  @PutMapping("/edit")
  public CommonResult<Boolean> updateById(@RequestBody SysRoleUpDTO dto) {
    log.info("更新角色信息");
    SysRoleBO bo = MapStructUtils.convert(dto, SysRoleBO.class);
    Boolean result = sysRoleService.updateRole(bo);
    log.info("更新角色信息是否成功, result:{}", result);
    return result ? CommonResult.fail(BasicCode.UPDATE_ERROR) : CommonResult.ok(BasicCode.SUCCESS);
  }

  /**
   * 根据id查询角色信息
   *
   * @param id 角色id
   * @return {@link CommonResult<SysRoleVO>}
   */
  @GetMapping("/{id}")
  public CommonResult<SysRoleVO> findById(@PathVariable Long id) {
    log.info("查询角色信息, id:{}", id);
    SysRolePO po = sysRoleService.findById(id);
    if (po == null) {
      return CommonResult.fail(BasicCode.NO_DATA);
    }
    return CommonResult.ok().addData(MapStructUtils.convert(po, SysRoleVO.class));
  }
}

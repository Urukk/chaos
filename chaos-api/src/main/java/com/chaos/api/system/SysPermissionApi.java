package com.chaos.api.system;

import com.chaos.common.core.enums.BasicCode;
import com.chaos.common.core.model.CommonResult;
import com.chaos.common.core.utils.MapStructUtils;
import com.chaos.system.entity.SysPermissionPO;
import com.chaos.system.entity.bo.SysPermissionBO;
import com.chaos.system.entity.dto.SysPermissionDTO;
import com.chaos.system.entity.dto.SysPermissionUpDTO;
import com.chaos.system.entity.vo.SysPermissionVO;
import com.chaos.system.service.SysPermissionService;
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
 * 基础模块-权限管理
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/24 10:20
 */
@RestController
@RequestMapping("api/v1/permission")
@Slf4j
public class SysPermissionApi {

  @Resource
  private SysPermissionService sysPermissionService;

  /**
   * 保存权限信息
   *
   * @param dto 权限信息
   * @return {@link CommonResult <Boolean>}
   */
  @PostMapping("/save")
  public CommonResult<Boolean> save(@RequestBody SysPermissionDTO dto) {
    log.info("新增权限信息");
    SysPermissionBO bo = MapStructUtils.convert(dto, SysPermissionBO.class);
    Boolean result = sysPermissionService.savePermission(bo);
    log.info("新增权限信息是否成功, result:{}", result);
    return result ? CommonResult.fail(BasicCode.INSERT_ERROR) : CommonResult.ok(BasicCode.SUCCESS);
  }

  /**
   * 删除权限信息
   *
   * @param ids 权限id数组
   * @return {@link CommonResult<Boolean>}
   */
  @DeleteMapping("/{ids}")
  public CommonResult<Boolean> deleteById(@PathVariable @NotNull Long[] ids) {
    Boolean result = false;
    if (ids.length > 0) {
      log.info("删除权限信息, id:{}", Arrays.toString(ids));
      result = sysPermissionService.batchDeleteById(Arrays.asList(ids));
      log.info("删除权限信息是否成功, result:{}", result);
    }
    return result ? CommonResult.fail(BasicCode.DELETE_ERROR) : CommonResult.ok(BasicCode.SUCCESS);
  }

  /**
   * 更新权限信息
   *
   * @param dto 权限信息
   * @return {@link CommonResult<Boolean>}
   */
  @PutMapping("/edit")
  public CommonResult<Boolean> updateById(@RequestBody SysPermissionUpDTO dto) {
    log.info("更新权限信息");
    SysPermissionBO bo = MapStructUtils.convert(dto, SysPermissionBO.class);
    Boolean result = sysPermissionService.updatePermission(bo);
    log.info("更新权限信息是否成功, result:{}", result);
    return result ? CommonResult.fail(BasicCode.UPDATE_ERROR) : CommonResult.ok(BasicCode.SUCCESS);
  }

  /**
   * 根据id查询权限信息
   *
   * @param id 权限id
   * @return {@link CommonResult<SysPermissionVO>}
   */
  @GetMapping("/{id}")
  public CommonResult<SysPermissionVO> findById(@PathVariable Long id) {
    log.info("查询权限信息, id:{}", id);
    SysPermissionPO po = sysPermissionService.findBySingleId(id);
    if (po == null) {
      return CommonResult.fail(BasicCode.NO_DATA);
    }
    return CommonResult.ok().addData(MapStructUtils.convert(po, SysPermissionVO.class));
  }

}

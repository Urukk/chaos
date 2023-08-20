package com.chaos.api.system;

import com.chaos.common.core.enums.BasicCode;
import com.chaos.common.core.model.CommonResult;
import com.chaos.common.core.utils.MapStructUtils;
import com.chaos.system.entity.SysUserPO;
import com.chaos.system.entity.bo.SysUserBO;
import com.chaos.system.entity.dto.SysUserDTO;
import com.chaos.system.entity.dto.SysUserUpDTO;
import com.chaos.system.entity.vo.SysUserVO;
import com.chaos.system.service.SysUserService;
import jakarta.annotation.Resource;
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
 * 基础模块-用户信息
 *
 * @author S.H.I.E.L.D
 * @since 2023-08-14 21:39
 */
@RestController
@RequestMapping("/api/v1/user")
@Slf4j
public class SysUserApi {

  @Resource private SysUserService sysUserService;

  /**
   * 保存用户信息
   *
   * @param dto 用户信息
   * @return {@link CommonResult<Boolean>}
   */
  @PostMapping("/save")
  public CommonResult<Boolean> save(@RequestBody SysUserDTO dto) {
    log.info("新增用户信息");
    SysUserBO bo = MapStructUtils.convert(dto, SysUserBO.class);
    Boolean result = sysUserService.saveUser(bo);
    log.info("新增用户信息是否成功, result:{}", result);
    return result ? CommonResult.fail(BasicCode.INSERT_ERROR) : CommonResult.ok(BasicCode.SUCCESS);
  }

  /**
   * 删除用户信息
   *
   * @param id 用户id
   * @return {@link CommonResult<Boolean>}
   */
  @DeleteMapping("/{id}")
  public CommonResult<Boolean> deleteById(@PathVariable Long id) {
    log.info("删除用户信息, id:{}", id);
    Boolean result = sysUserService.logicDeleteById(id);
    log.info("删除用户信息是否成功, result:{}", result);
    return result ? CommonResult.fail(BasicCode.DELETE_ERROR) : CommonResult.ok(BasicCode.SUCCESS);
  }

  /**
   * 更新用户信息
   *
   * @param dto 用户信息
   * @return {@link CommonResult<Boolean>}
   */
  @PutMapping("/edit")
  public CommonResult<Boolean> updateById(@RequestBody SysUserUpDTO dto) {
    log.info("更新用户信息");
    SysUserBO bo = MapStructUtils.convert(dto, SysUserBO.class);
    Boolean result = sysUserService.updateUser(bo);
    log.info("更新用户信息是否成功, result:{}", result);
    return result ? CommonResult.fail(BasicCode.UPDATE_ERROR) : CommonResult.ok(BasicCode.SUCCESS);
  }

  /**
   * 根据id查询用户信息
   *
   * @param id 用户id
   * @return {@link CommonResult<SysUserVO>}
   */
  @GetMapping("/{id}")
  public CommonResult<SysUserVO> findById(@PathVariable Long id) {
    log.info("查询用户信息, id:{}", id);
    SysUserPO po = sysUserService.findById(id);
    if (po == null) {
      return CommonResult.fail(BasicCode.NO_DATA);
    }
    return CommonResult.ok().addData(MapStructUtils.convert(po, SysUserVO.class));
  }
}

package com.chaos.api.system;

import com.chaos.common.core.enums.BasicCode;
import com.chaos.common.core.model.CommonResult;
import com.chaos.common.core.utils.MapStructUtils;
import com.chaos.common.log.annotation.Log;
import com.chaos.common.log.enums.BusinessType;
import com.chaos.system.entity.SysPostPO;
import com.chaos.system.entity.bo.SysPostBO;
import com.chaos.system.entity.dto.SysPostDTO;
import com.chaos.system.entity.dto.SysPostUpDTO;
import com.chaos.system.entity.vo.SysPostVO;
import com.chaos.system.service.SysPostService;
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
 * 基础模块-岗位管理
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/24 09:58
 */
@RestController
@Slf4j
@RequestMapping("/api/v1/post")
public class SysPostApi {

  @Resource private SysPostService sysPostService;

  /**
   * 保存岗位信息
   *
   * @param dto 岗位信息
   * @return {@link CommonResult <Boolean>}
   */
  @PostMapping("/save")
  @Log(title = "岗位管理", businessType = BusinessType.INSERT)
  public CommonResult<Boolean> save(@RequestBody SysPostDTO dto) {
    log.info("新增岗位信息");
    SysPostBO bo = MapStructUtils.convert(dto, SysPostBO.class);
    Boolean result = sysPostService.savePost(bo);
    log.info("新增岗位信息是否成功, result:{}", result);
    return result ? CommonResult.fail(BasicCode.INSERT_ERROR) : CommonResult.ok(BasicCode.SUCCESS);
  }

  /**
   * 删除岗位信息
   *
   * @param ids 岗位id数组
   * @return {@link CommonResult<Boolean>}
   */
  @DeleteMapping("/{ids}")
  @Log(title = "岗位管理", businessType = BusinessType.DELETE)
  public CommonResult<Boolean> deleteById(@PathVariable @NotNull Long[] ids) {
    Boolean result = false;
    if (ids.length > 0) {
      log.info("删除岗位信息, id:{}", Arrays.toString(ids));
      result = sysPostService.batchDeleteById(Arrays.asList(ids));
      log.info("删除岗位信息是否成功, result:{}", result);
    }
    return result ? CommonResult.fail(BasicCode.DELETE_ERROR) : CommonResult.ok(BasicCode.SUCCESS);
  }

  /**
   * 更新岗位信息
   *
   * @param dto 岗位信息
   * @return {@link CommonResult<Boolean>}
   */
  @PutMapping("/edit")
  @Log(title = "岗位管理", businessType = BusinessType.UPDATE)
  public CommonResult<Boolean> updateById(@RequestBody SysPostUpDTO dto) {
    log.info("更新岗位信息");
    SysPostBO bo = MapStructUtils.convert(dto, SysPostBO.class);
    Boolean result = sysPostService.updatePost(bo);
    log.info("更新岗位信息是否成功, result:{}", result);
    return result ? CommonResult.fail(BasicCode.UPDATE_ERROR) : CommonResult.ok(BasicCode.SUCCESS);
  }

  /**
   * 根据id查询岗位信息
   *
   * @param id 岗位id
   * @return {@link CommonResult<SysPostVO>}
   */
  @GetMapping("/{id}")
  public CommonResult<SysPostVO> findById(@PathVariable Long id) {
    log.info("查询岗位信息, id:{}", id);
    SysPostPO po = sysPostService.findBySingleId(id);
    if (po == null) {
      return CommonResult.fail(BasicCode.NO_DATA);
    }
    return CommonResult.ok().addData(MapStructUtils.convert(po, SysPostVO.class));
  }
}

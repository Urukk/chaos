package com.chaos.api.system;

import com.chaos.common.core.enums.BasicCode;
import com.chaos.common.core.model.CommonResult;
import com.chaos.common.core.utils.MapStructUtils;
import com.chaos.system.entity.SysDeptPO;
import com.chaos.system.entity.bo.SysDeptBO;
import com.chaos.system.entity.dto.SysDeptDTO;
import com.chaos.system.entity.dto.SysDeptUpDTO;
import com.chaos.system.entity.vo.SysDeptVO;
import com.chaos.system.service.SysDeptService;
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
 * 基础模块-部门管理
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/24 09:40
 */
@RestController
@RequestMapping("/api/v1/dept")
@Slf4j
public class SysDeptApi {

  @Resource private SysDeptService sysDeptService;

  /**
   * 保存部门信息
   *
   * @param dto 部门信息
   * @return {@link CommonResult <Boolean>}
   */
  @PostMapping("/save")
  public CommonResult<Boolean> save(@RequestBody SysDeptDTO dto) {
    log.info("新增部门信息");
    SysDeptBO bo = MapStructUtils.convert(dto, SysDeptBO.class);
    Boolean result = sysDeptService.saveDept(bo);
    log.info("新增部门信息是否成功, result:{}", result);
    return result ? CommonResult.fail(BasicCode.INSERT_ERROR) : CommonResult.ok(BasicCode.SUCCESS);
  }

  /**
   * 删除部门信息
   *
   * @param ids 部门id数组
   * @return {@link CommonResult<Boolean>}
   */
  @DeleteMapping("/{ids}")
  public CommonResult<Boolean> deleteById(@PathVariable @NotNull Long[] ids) {
    Boolean result = false;
    if (ids.length > 0) {
      log.info("删除部门信息, id:{}", Arrays.toString(ids));
      result = sysDeptService.batchDeleteById(Arrays.asList(ids));
      log.info("删除部门信息是否成功, result:{}", result);
    }
    return result ? CommonResult.fail(BasicCode.DELETE_ERROR) : CommonResult.ok(BasicCode.SUCCESS);
  }

  /**
   * 更新部门信息
   *
   * @param dto 部门信息
   * @return {@link CommonResult<Boolean>}
   */
  @PutMapping("/edit")
  public CommonResult<Boolean> updateById(@RequestBody SysDeptUpDTO dto) {
    log.info("更新部门信息");
    SysDeptBO bo = MapStructUtils.convert(dto, SysDeptBO.class);
    Boolean result = sysDeptService.updateDept(bo);
    log.info("更新部门信息是否成功, result:{}", result);
    return result ? CommonResult.fail(BasicCode.UPDATE_ERROR) : CommonResult.ok(BasicCode.SUCCESS);
  }

  /**
   * 根据id查询部门信息
   *
   * @param id 部门id
   * @return {@link CommonResult<SysDeptVO>}
   */
  @GetMapping("/{id}")
  public CommonResult<SysDeptVO> findById(@PathVariable Long id) {
    log.info("查询部门信息, id:{}", id);
    SysDeptPO po = sysDeptService.findBySingleId(id);
    if (po == null) {
      return CommonResult.fail(BasicCode.NO_DATA);
    }
    return CommonResult.ok().addData(MapStructUtils.convert(po, SysDeptVO.class));
  }
}

package com.chaos.api.system;

import com.chaos.common.core.enums.BasicCode;
import com.chaos.common.core.model.CommonResult;
import com.chaos.common.core.utils.MapStructUtils;
import com.chaos.common.log.annotation.Log;
import com.chaos.common.log.enums.BusinessType;
import com.chaos.system.entity.SysOperationLogPO;
import com.chaos.system.entity.bo.SysOperationLogBO;
import com.chaos.system.entity.dto.SysOperationLogDTO;
import com.chaos.system.entity.dto.SysOperationLogUpDTO;
import com.chaos.system.entity.vo.SysOperationLogVO;
import com.chaos.system.service.SysOperationLogService;
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
 * 基础模块-操作日志
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/24 10:09
 */
@RestController
@RequestMapping("api/v1/sysOperationLog")
@Slf4j
public class SysOperationLogApi {

  @Resource
  private SysOperationLogService operationLogService;

  /**
   * 保存操作日志信息
   *
   * @param dto 操作日志信息
   * @return {@link CommonResult <Boolean>}
   */
  @PostMapping("/save")
  @Log(title = "操作日志", businessType = BusinessType.INSERT)
  public CommonResult<Boolean> save(@RequestBody SysOperationLogDTO dto) {
    log.info("新增操作日志信息");
    SysOperationLogBO bo = MapStructUtils.convert(dto, SysOperationLogBO.class);
    Boolean result = operationLogService.saveOperationLog(bo);
    log.info("新增操作日志信息是否成功, result:{}", result);
    return result ? CommonResult.fail(BasicCode.INSERT_ERROR) : CommonResult.ok(BasicCode.SUCCESS);
  }

  /**
   * 删除操作日志信息
   *
   * @param ids 操作日志id数组
   * @return {@link CommonResult<Boolean>}
   */
  @DeleteMapping("/{ids}")
  @Log(title = "操作日志", businessType = BusinessType.DELETE)
  public CommonResult<Boolean> deleteById(@PathVariable @NotNull Long[] ids) {
    Boolean result = false;
    if (ids.length > 0) {
      log.info("删除操作日志信息, id:{}", Arrays.toString(ids));
      result = operationLogService.batchDeleteById(Arrays.asList(ids));
      log.info("删除操作日志信息是否成功, result:{}", result);
    }
    return result ? CommonResult.fail(BasicCode.DELETE_ERROR) : CommonResult.ok(BasicCode.SUCCESS);
  }

  /**
   * 更新操作日志信息
   *
   * @param dto 操作日志信息
   * @return {@link CommonResult<Boolean>}
   */
  @PutMapping("/edit")
  @Log(title = "操作日志", businessType = BusinessType.UPDATE)
  public CommonResult<Boolean> updateById(@RequestBody SysOperationLogUpDTO dto) {
    log.info("更新操作日志信息");
    SysOperationLogBO bo = MapStructUtils.convert(dto, SysOperationLogBO.class);
    Boolean result = operationLogService.updateOperationLog(bo);
    log.info("更新操作日志信息是否成功, result:{}", result);
    return result ? CommonResult.fail(BasicCode.UPDATE_ERROR) : CommonResult.ok(BasicCode.SUCCESS);
  }

  /**
   * 根据id查询操作日志信息
   *
   * @param id 操作日志id
   * @return {@link CommonResult<SysOperationLogVO>}
   */
  @GetMapping("/{id}")
  public CommonResult<SysOperationLogVO> findById(@PathVariable Long id) {
    log.info("查询操作日志信息, id:{}", id);
    SysOperationLogPO po = operationLogService.findBySingleId(id);
    if (po == null) {
      return CommonResult.fail(BasicCode.NO_DATA);
    }
    return CommonResult.ok().addData(MapStructUtils.convert(po, SysOperationLogVO.class));
  }

}

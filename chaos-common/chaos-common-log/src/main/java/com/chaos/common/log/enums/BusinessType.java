package com.chaos.common.log.enums;

/**
 * 业务操作类型(借鉴ruoyi)
 *
 * @author S.H.I.E.L.D
 * @since 2023/09/08 11:11
 */
public enum BusinessType {
  /** 其它 */
  OTHER,

  /** 新增 */
  INSERT,

  /** 修改 */
  UPDATE,

  /** 删除 */
  DELETE,

  /** 授权 */
  GRANT,

  /** 导出 */
  EXPORT,

  /** 导入 */
  IMPORT,

  /** 强退 */
  FORCE,

  /** 生成代码 */
  GENCODE,

  /** 清空数据 */
  CLEAN,
}

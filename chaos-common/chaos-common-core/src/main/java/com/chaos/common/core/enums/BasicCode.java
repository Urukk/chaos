package com.chaos.common.core.enums;

/**
 * 基础编码枚举
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/18 16:43
 */
public enum BasicCode implements IMessage {

  /**
   * 规范响应体中的响应码和响应信息
   */
  SUCCESS("200", "操作成功"),

  TOKEN_IS_EMPTY("40101", "token不能为空"),

  TOKEN_IS_EXPIRED("40102", "token已过期"),

  TOKEN_IS_ILLEGAL("40103", "token不合法"),

  FAILED("500", "操作失败"),

  VALIDATE_FAILED("501", "参数校验失败或为空"),

  UNKNOWN_ERROR("502", "未知错误"),

  NO_DATA("503", "未查询到数据"),

  INSERT_ERROR("504", "新增失败"),

  UPDATE_ERROR("505", "修改失败"),

  DELETE_ERROR("506", "删除失败"),

  IMPORT_ERROR("507", "导入失败"),

  UPLOAD_ERROR("508", "上传失败"),

  /**
   * 登录相关的错误提示
   */
  ERROR_LOGIN_NOT_EMPTY("510", "账号或密码不能为空"),

  ERROR_LOGIN_LOCK("511", "密码输错次数过多,已被锁定30分钟"),

  ERROR_LOGIN("512", "登录失败,请检查账号或密码是否正确");



  /**
   * 响应码
   */
  private final String code;

  /**
   * 响应信息
   */
  private final String message;

  BasicCode(String errorCode, String errorMessage) {
    this.code = errorCode;
    this.message = errorMessage;
  }

  @Override
  public String getCode() {
    return this.code;
  }

  @Override
  public String getMessage() {
    return this.message;
  }
}

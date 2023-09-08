package com.chaos.common.log.annotation;

import com.chaos.common.log.enums.BusinessType;
import com.chaos.common.log.enums.OperatorType;
import java.lang.annotation.*;

/**
 * 自定义操作日志记录注解(借鉴ruoyi)
 *
 * @author S.H.I.E.L.D
 * @since 2023/09/08 11:11
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

  /** 模块 */
  String title() default "";

  /** 功能 */
  BusinessType businessType() default BusinessType.OTHER;

  /** 操作人类别 */
  OperatorType operatorType() default OperatorType.MANAGE;

  /** 是否保存请求的参数 */
  boolean isSaveRequestData() default true;

  /** 是否保存响应的参数 */
  boolean isSaveResponseData() default true;

  /** 排除指定的请求参数 */
  String[] excludeParamNames() default {};
}

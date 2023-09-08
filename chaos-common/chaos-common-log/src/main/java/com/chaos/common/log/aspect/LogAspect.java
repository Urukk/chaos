package com.chaos.common.log.aspect;

import cn.hutool.core.lang.Dict;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.ttl.TransmittableThreadLocal;
import com.chaos.common.core.utils.JsonUtils;
import com.chaos.common.core.utils.ServletUtils;
import com.chaos.common.core.utils.SpringUtils;
import com.chaos.common.log.annotation.Log;
import com.chaos.common.log.enums.BusinessStatus;
import com.chaos.common.log.event.OperationLogEvent;
import com.chaos.common.security.utils.SecurityUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * 操作日志记录处理(借鉴ruoyi)
 *
 * @author S.H.I.E.L.D
 * @since 2023/09/08 11:11
 */
@Slf4j
@Aspect
@Component
public class LogAspect {

  /** 排除敏感属性字段 */
  protected static final String[] EXCLUDE_PROPERTIES = {
    "password", "oldPassword", "newPassword", "confirmPassword"
  };

  /** 计算操作消耗时间 */
  private static final ThreadLocal<StopWatch> TIME_THREADLOCAL = new TransmittableThreadLocal<>();

  /**
   * 处理请求前执行
   *
   * @param joinPoint 切点
   * @param controllerLog 日志注解
   */
  @Before(value = "@annotation(controllerLog)")
  public void boBefore(JoinPoint joinPoint, Log controllerLog) {
    StopWatch stopWatch = new StopWatch();
    TIME_THREADLOCAL.set(stopWatch);
    stopWatch.start();
  }

  /**
   * 处理完请求后执行
   *
   * @param joinPoint 切点
   */
  @AfterReturning(pointcut = "@annotation(controllerLog)", returning = "result")
  public void doAfterReturning(JoinPoint joinPoint, Log controllerLog, Object result) {
    handleLog(joinPoint, controllerLog, null, result);
  }

  /**
   * 拦截异常操作
   *
   * @param joinPoint 切点
   * @param e 异常
   */
  @AfterThrowing(value = "@annotation(controllerLog)", throwing = "e")
  public void doAfterThrowing(JoinPoint joinPoint, Log controllerLog, Exception e) {
    handleLog(joinPoint, controllerLog, e, null);
  }

  /**
   * 保存日志
   *
   * @param joinPoint 切点
   * @param controllerLog 日志注解
   * @param e 异常
   * @param result 结果
   */
  protected void handleLog(
      final JoinPoint joinPoint, Log controllerLog, final Exception e, Object result) {
    try {

      // *========数据库日志=========*//
      OperationLogEvent event = new OperationLogEvent();
      event.setStatus(BusinessStatus.SUCCESS.ordinal());
      // 请求的地址
      String ip = ServletUtils.getClientIP();
      event.setOperationIp(ip);
      event.setOperationUrl(
          StringUtils.substring(
              Objects.requireNonNull(ServletUtils.getRequest()).getRequestURI(), 0, 255));
      event.setOperationName(SecurityUtils.getLoginUsername());

      if (e != null) {
        event.setStatus(BusinessStatus.FAIL.ordinal());
        event.setErrorMsg(StringUtils.substring(e.getMessage(), 0, 2000));
      }
      // 设置方法名称
      String className = joinPoint.getTarget().getClass().getName();
      String methodName = joinPoint.getSignature().getName();
      event.setRequestMethod(className + "." + methodName + "()");
      // 设置请求方式
      event.setRequestMethod(ServletUtils.getRequest().getMethod());
      // 处理设置注解上的参数
      getControllerMethodDescription(joinPoint, controllerLog, event, result);
      // 设置消耗时间
      StopWatch stopWatch = TIME_THREADLOCAL.get();
      stopWatch.stop();
      event.setDuration(stopWatch.getTime());
      // 发布事件保存数据库
      SpringUtils.context().publishEvent(event);
    } catch (Exception exp) {
      // 记录本地异常日志
      log.error("异常信息:{}", exp.getMessage());
      exp.printStackTrace();
    } finally {
      TIME_THREADLOCAL.remove();
    }
  }

  /**
   * 获取注解中对方法的描述信息 用于Controller层注解
   *
   * @param joinPoint 切点
   * @param log 日志
   * @param event 操作日志事件
   * @param result 结果
   * @throws Exception 异常
   */
  public void getControllerMethodDescription(
      JoinPoint joinPoint, Log log, OperationLogEvent event, Object result) throws Exception {
    // 设置action动作
    event.setBusinessType(log.businessType().ordinal());
    // 设置标题
    event.setTitle(log.title());
    // 是否需要保存request，参数和值
    if (log.isSaveRequestData()) {
      // 获取参数的信息，传入到数据库中。
      setRequestValue(joinPoint, event, log.excludeParamNames());
    }
    // 是否需要保存response，参数和值
    if (log.isSaveResponseData() && ObjectUtil.isNotNull(result)) {
      event.setResponseContent(StringUtils.substring(JsonUtils.toJsonString(result), 0, 2000));
    }
  }

  /**
   * 获取请求的参数，放到log中
   *
   * @param joinPoint 切点
   * @param event 操作日志事件
   * @param excludeParamNames 排除的参数名称
   * @throws Exception 异常
   */
  private void setRequestValue(
      JoinPoint joinPoint, OperationLogEvent event, String[] excludeParamNames) throws Exception {
    Map<String, String> paramsMap = ServletUtils.getParamMap(ServletUtils.getRequest());
    String requestMethod = event.getRequestMethod();
    if (MapUtil.isEmpty(paramsMap) && HttpMethod.PUT.name().equals(requestMethod)
        || HttpMethod.POST.name().equals(requestMethod)) {
      String params = argsArrayToString(joinPoint.getArgs(), excludeParamNames);
      event.setRequestParams(StringUtils.substring(params, 0, 2000));
    } else {
      MapUtil.removeAny(paramsMap, EXCLUDE_PROPERTIES);
      MapUtil.removeAny(paramsMap, excludeParamNames);
      event.setRequestParams(StringUtils.substring(JsonUtils.toJsonString(paramsMap), 0, 2000));
    }
  }

  /**
   * 参数拼装
   *
   * @param paramsArray 参数数组
   * @param excludeParamNames 排除的参数名称
   * @return 拼装后的字符串
   */
  private String argsArrayToString(Object[] paramsArray, String[] excludeParamNames) {
    StringJoiner params = new StringJoiner(" ");
    if (ArrayUtil.isEmpty(paramsArray)) {
      return params.toString();
    }
    for (Object o : paramsArray) {
      if (ObjectUtil.isNotNull(o) && !isFilterObject(o)) {
        String str = JsonUtils.toJsonString(o);
        Dict dict = JsonUtils.parseMap(str);
        if (MapUtil.isNotEmpty(dict)) {
          MapUtil.removeAny(dict, EXCLUDE_PROPERTIES);
          MapUtil.removeAny(dict, excludeParamNames);
          str = JsonUtils.toJsonString(dict);
        }
        params.add(str);
      }
    }
    return params.toString();
  }

  /**
   * 判断是否需要过滤的对象。
   *
   * @param o 对象信息。
   * @return 如果是需要过滤的对象，则返回true；否则返回false。
   */
  @SuppressWarnings("rawtypes")
  public boolean isFilterObject(final Object o) {
    Class<?> clazz = o.getClass();
    if (clazz.isArray()) {
      return clazz.getComponentType().isAssignableFrom(MultipartFile.class);
    }

    if (Collection.class.isAssignableFrom(clazz)) {
      Collection collection = (Collection) o;
      for (Object value : collection) {
        if (value instanceof MultipartFile) {
          return true;
        }
      }
    } else if (Map.class.isAssignableFrom(clazz)) {
      Map map = (Map) o;
      for (Object value : map.values()) {
        if (value instanceof MultipartFile) {
          return true;
        }
      }
    }

    return o instanceof MultipartFile
        || o instanceof HttpServletRequest
        || o instanceof HttpServletResponse
        || o instanceof BindingResult;
  }
}

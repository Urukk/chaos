package com.chaos.common.core.utils;

import cn.hutool.extra.spring.SpringUtil;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * spring 工具类
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/18 09:10
 */
@Component
public final class SpringUtils extends SpringUtil {

  /**
   * 如果BeanFactory包含一个与所给名称匹配的bean定义，则返回true
   *
   * @param beanName bean名字
   * @return boolean
   */
  public static boolean containsBean(String beanName) {
    return getBeanFactory().containsBean(beanName);
  }

  /**
   * 判断以给定名字注册的bean定义是一个singleton还是一个prototype。
   * 如果与给定名字相应的bean定义没有被找到，将会抛出一个异常（NoSuchBeanDefinitionException）
   *
   * @param beanName bean名字
   * @return boolean
   */
  public static boolean isSingleton(String beanName) throws NoSuchBeanDefinitionException {
    return getBeanFactory().isSingleton(beanName);
  }

  /**
   * 如果给定的bean名字在bean定义中存在，则返回这些类型
   *
   * @return Class 注册对象的类型
   * @param beanName bean名字
   * @throws NoSuchBeanDefinitionException 没有这样bean定义例外
   */
  public static Class<?> getType(String beanName) throws NoSuchBeanDefinitionException {
    return getBeanFactory().getType(beanName);
  }

  /**
   * 如果给定的bean名字在bean定义中有别名，则返回这些别名
   *
   * @param beanName bean名字
   * @return {@link String[]}
   * @throws NoSuchBeanDefinitionException 没有这样bean定义例外
   */
  public static String[] getAliases(String beanName) throws NoSuchBeanDefinitionException {
    return getBeanFactory().getAliases(beanName);
  }

  /**
   * 获取aop代理对象
   *
   * @param invoker 调用者
   * @param <T> 泛型
   * @return {@link T}
   */
  @SuppressWarnings("unchecked")
  public static <T> T getAopProxy(T invoker) {
    return (T) AopContext.currentProxy();
  }

  /**
   * 获取spring上下文
   *
   * @return {@link ApplicationContext}
   */
  public static ApplicationContext context() {
    return getApplicationContext();
  }
}

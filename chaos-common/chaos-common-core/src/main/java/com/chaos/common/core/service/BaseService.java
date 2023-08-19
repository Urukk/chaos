package com.chaos.common.core.service;

import com.chaos.common.core.entity.BasePO;

/**
 * service基类
 *
 * @author S.H.I.E.L.D
 * @since 2023-08-14 21:07
 */
public interface BaseService<T extends BasePO> {

  /**
   * 根据id查询
   *
   * @param id id
   * @return {@link T}
   */
  T findById(Long id);

  /**
   * 保存
   *
   * @param entity 实体
   */
    T save(T entity);

  /**
   * 根据id更新
   *
   * @param entity 实体
   */
  T updateById(T entity);

  /**
   * 根据id删除
   *
   * @param id id
   */
  void deleteById(Long id);

  /**
   * 根据id逻辑删除
   *
   * @param id id
   */
  Boolean logicDeleteById(Long id);
}

package com.chaos.common.core.service.impl;

import com.chaos.common.core.dao.BaseDao;
import com.chaos.common.core.entity.BasePO;
import com.chaos.common.core.service.BaseService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * service 实现类基类
 *
 * @author S.H.I.E.L.D
 * @since 2023-08-14 21:14
 */
@Service
public class BaseServiceImpl <D extends BaseDao<T>, T extends BasePO> implements BaseService<T> {

  @Resource
  protected D dao;

  @Override
  public T findById(Long id) {
    return dao.findById(id).orElse(null);
  }

  @Override
  public void save(T entity) {
    dao.save(entity);
  }

  @Override
  public void updateById(T entity) {
    dao.save(entity);
  }

  @Override
  public void deleteById(Long id) {
    dao.deleteById(id);
  }

  @Override
  public void logicDeleteById(Long id) {
    dao.logicDeleteById(id);
  }
}

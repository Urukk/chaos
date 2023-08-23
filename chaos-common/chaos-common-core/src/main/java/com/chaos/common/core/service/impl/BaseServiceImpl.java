package com.chaos.common.core.service.impl;

import com.chaos.common.core.dao.BaseRepository;
import com.chaos.common.core.entity.BasePO;
import com.chaos.common.core.service.BaseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * service 抽象实现类
 *
 * @author S.H.I.E.L.D
 * @since 2023-08-14 21:14
 */
@Service
public abstract class BaseServiceImpl <D extends BaseRepository<T>, T extends BasePO> implements BaseService<T> {

  @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
  @Autowired
  protected D dao;

  @Override
  public T findById(Long id) {
    return dao.findById(id).orElse(null);
  }

  @Override
  public T save(T entity) {
    return dao.save(entity);
  }

  @Override
  public T updateById(T entity) {
    return dao.save(entity);
  }

  @Override
  public void deleteById(Long id) {
    dao.deleteById(id);
  }

  @Override
  public Boolean logicDeleteById(Long id) {
    return dao.logicDeleteById(id) > 0;
  }

  @Override
  public Boolean batchDeleteById(List<Long> ids) {
    return dao.batchDeleteById(ids) > 0;
  }
}

package com.chaos.common.core.dao;

import com.chaos.common.core.entity.BasePO;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

/**
 * dao基类
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/05 15:14
 */
@NoRepositoryBean
public interface BaseRepository<T extends BasePO> extends JpaRepository<T, Long> {

  @Override
  @Query("select t from #{#entityName} t where t.id = ?1 and t.isDeleted = 0")
  @Transactional(readOnly = true)
  Optional<T> findById(Long id);

  @Override
  @Query("select t from #{#entityName} t where t.isDeleted = 0")
  @Transactional(readOnly = true)
  List<T> findAll();

  @Query("select t from #{#entityName} t where t.isDeleted = 0 order by t.id desc")
  @Transactional(readOnly = true)
  List<T> findAllDesc();

  @Query("select t from #{#entityName} t where t.isDeleted = 0 order by t.id asc")
  @Transactional(readOnly = true)
  List<T> findAllAsc();

  @Query("select t from #{#entityName} t where t.id = ?1 and t.isDeleted = 0")
  @Transactional(readOnly = true)
  Optional<T> findByIdNotDeleted(Long id);

  @Modifying
  @Query("update #{#entityName} t set t.isDeleted = 1, t.updateTime = now() where t.id = ?1")
  @Transactional(rollbackFor = Exception.class)
  int logicDeleteById(Long id);

  @Modifying
  @Query("update #{#entityName} t set t.isDeleted = 1, t.updateTime = now() where t.id in (?1)")
  @Transactional(rollbackFor = Exception.class)
  int batchDeleteById(List<Long> ids);
}

package com.chaos.system.dao;

import com.chaos.common.core.dao.BaseRepository;
import com.chaos.system.entity.SysUserPO;
import org.springframework.stereotype.Repository;

/**
 * dao层-用户信息
 *
 * @author S.H.I.E.L.D
 * @since 2023/08/05 14:21
 */
@Repository
public interface SysUserRepository extends BaseRepository<SysUserPO> {

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return SysUserPO 用户信息
     */
    SysUserPO findByUsername(String username);

    /**
     * 根据用户编号查询用户
     *
     * @param userNo 用户编号
     * @return SysUserPO 用户信息
     */
    SysUserPO findByUserNo(String userNo);
}

package com.chaos.system.service.impl;

import com.chaos.common.core.service.impl.BaseServiceImpl;
import com.chaos.system.dao.UserDao;
import com.chaos.system.entity.UserPO;
import com.chaos.system.service.UserService;
import org.springframework.stereotype.Service;

/**
 * service实现类-用户信息
 *
 * @author S.H.I.E.L.D
 * @since 2023-08-14 21:30
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserDao, UserPO> implements UserService {}
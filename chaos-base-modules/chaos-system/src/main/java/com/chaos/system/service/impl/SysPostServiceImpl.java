package com.chaos.system.service.impl;

import com.chaos.common.core.service.impl.BaseServiceImpl;
import com.chaos.system.dao.SysPostRepository;
import com.chaos.system.entity.SysPostPO;
import com.chaos.system.service.SysPostService;
import org.springframework.stereotype.Service;

/**
 * service层实现类-岗位管理
 *
 * @author S.H.I.E.L.D
 * @since 2023-08-24 0:00
 */
@Service
public class SysPostServiceImpl extends BaseServiceImpl<SysPostRepository, SysPostPO> implements
    SysPostService {}

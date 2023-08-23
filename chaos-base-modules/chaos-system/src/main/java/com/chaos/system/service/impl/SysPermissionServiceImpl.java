package com.chaos.system.service.impl;

import com.chaos.common.core.service.impl.BaseServiceImpl;
import com.chaos.system.dao.SysPermissionRepository;
import com.chaos.system.entity.SysPermissionPO;
import com.chaos.system.service.SysPermissionService;
import org.springframework.stereotype.Service;

/**
 * service层实现类-权限管理
 *
 * @author S.H.I.E.L.D
 * @since 2023-08-24 0:01
 */
@Service
public class SysPermissionServiceImpl extends BaseServiceImpl<SysPermissionRepository, SysPermissionPO> implements
    SysPermissionService {}

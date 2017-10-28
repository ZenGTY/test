package org.hospital.service.impl;

import org.hospital.domain.Permission;
import org.hospital.domain.PermissionDAO;
import org.hospital.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by pismery on 2017-10-25.
 */
@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDAO pDao;

    @Override
    public Permission getPermissionById(int id) {
        return pDao.findById(id);
    }
}

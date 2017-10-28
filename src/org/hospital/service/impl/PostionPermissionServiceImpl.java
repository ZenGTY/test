package org.hospital.service.impl;

import org.hospital.domain.PositionPermission;
import org.hospital.domain.PositionPermissionDAO;
import org.hospital.service.PositionPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by pismery on 2017-10-25.
 */
@Service
@Transactional
public class PostionPermissionServiceImpl implements PositionPermissionService{

    @Autowired
    PositionPermissionDAO ppDao;

    @Override
    public List<PositionPermission> getByPostionId(int positionId) {
        List<PositionPermission> result = ppDao.findByProperty(ppDao.POSITION_ID,positionId);
        return result;
    }


}

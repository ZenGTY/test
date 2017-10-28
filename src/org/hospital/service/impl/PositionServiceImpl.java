package org.hospital.service.impl;

import org.hospital.domain.Permission;
import org.hospital.domain.PermissionDAO;
import org.hospital.domain.Position;
import org.hospital.domain.PositionDAO;
import org.hospital.domain.PositionPermission;
import org.hospital.domain.PositionPermissionDAO;
import org.hospital.domain.PositionPermissionId;
import org.hospital.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pismery on 2017-10-25.
 */
@Service
@Transactional
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionPermissionDAO ppDao;
    @Autowired
    private PositionDAO psDao;
    @Autowired
    private PermissionDAO pmDao;

    @Override
    public List<Permission> getPermision(int positionId) {
        List<Permission> result = new ArrayList<Permission>();
        List<PositionPermission> ppList = ppDao.findByProperty(ppDao.POSITION_ID, positionId);
        for (int i = 0; i < ppList.size(); i++) {
            result.add(pmDao.findById(ppList.get(i).getId().getPermissionId()));
        }
        return result;
    }

    @Override
    public Boolean isPermisionEnough(int positionId, String permissionName, int rank) {
        Position position = psDao.findById(positionId);
        if(position.getRank() < rank) {
            return false;
        }
        
        List<Permission> pmList = pmDao.findByProperty(pmDao.NAME, permissionName);
        if(pmList.size() <= 0) {
        	return false;
        }
        PositionPermission pp = ppDao.findById(new PositionPermissionId(positionId,pmList.get(0).getPermissionId()));

        if(pp == null) {
        	return false;
        }
        return true;
    }

	@Override
	public List<Position> getByPermission(Permission permission) {
		List<PositionPermission> ppList = ppDao.findByProperty("id.permissionId", 20);
		System.out.println("getByPermission.ppList : "+JSON.toJSONString(ppList));
		
		// TODO Auto-generated method stub
		return null;
	}
}

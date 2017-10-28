package org.hospital.service;


import java.util.List;

import org.hospital.domain.Permission;
import org.hospital.domain.Position;

/**
 * Created by pismery on 2017-10-25.
 */
public interface PositionService {

    List<Permission> getPermision(int positionId);

    /**
     * 检测职位是否有足够权限
     * @param positionId  职位编号
     * @param permissionName  权限名称
     * @param rank 职位等级
     * @return true:足够；false:权限不足
     */
    Boolean isPermisionEnough(int positionId,String permissionName,int rank);
    
    /**
     * 获取具有指定权限的所有职位
     * @param permission
     * @return
     */
    List<Position> getByPermission(Permission permission);
}

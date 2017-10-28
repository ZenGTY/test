package org.hospital.service;


import java.util.List;

import org.hospital.domain.BillProject;
import org.hospital.domain.BillProjectId;

/**
 * Created by pismery on 2017-10-25.
 */
public interface BillProjectService {

    /**
     * 根据Id获取BillProject对象
     * @param pk
     * @return
     */
    BillProject getByPk(BillProjectId pk);

    /**
     * save将BillProject对象写入数据库
     * @param entity
     */
    BillProject addEntity(BillProject entity);

    /**
     * 更新BillProject对象至数据库
     * @param entity
     * @return
     */
    BillProject updateEntity(BillProject entity);

    /**
     * 将一组BillProject对象写入数据库
     * @param bpList
     * @return
     */
    List<BillProject> addEntityList(List<BillProject> bpList);

}

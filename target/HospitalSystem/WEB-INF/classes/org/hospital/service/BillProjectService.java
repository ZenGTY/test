package org.hospital.service;

import org.hospital.entity.BillProject;

/**
 * Created by pismery on 2017-10-25.
 */
public interface BillProjectService {

    /**
     * 根据Id获取BillProject对象
     * @param id
     * @return
     */
    BillProject getBillById(Long id);

    /**
     * 将BillProject对象写入数据库
     * @param entity
     */
    BillProject addBill(BillProject entity);

    /**
     * 更新BillProject对象至数据库
     * @param entity
     * @return
     */
    BillProject updateBill(BillProject entity);


}

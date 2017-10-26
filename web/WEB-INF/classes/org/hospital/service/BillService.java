package org.hospital.service;

import org.hospital.entity.Bill;

/**
 * Created by pismery on 2017-10-24.
 */
public interface BillService {

    /**
     * 根据Id获取Bill对象
     * @param id
     * @return
     */
    Bill getBillById(Long id);

    /**
     * 将Bill对象写入数据库
     * @param entity
     */
    Bill addBill(Bill entity);

    /**
     * 更新Bill
     * @param entity
     * @return
     */
    Bill updateBill(Bill entity);



}

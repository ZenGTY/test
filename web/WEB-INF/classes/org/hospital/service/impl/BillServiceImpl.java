package org.hospital.service.impl;

import org.hospital.dao.BillDao;
import org.hospital.entity.Bill;
import org.hospital.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by pismery on 2017-10-24.
 */
@Service
public class BillServiceImpl implements BillService {


    @Autowired
    private BillDao billDao;

    public Bill updateBill(Bill entity) {
        return billDao.merge(entity);
    }

    public Bill addBill(Bill entity) {
        return billDao.merge(entity);
    }

    public Bill getBillById(Long id) {
        return billDao.get(id);
    }
}

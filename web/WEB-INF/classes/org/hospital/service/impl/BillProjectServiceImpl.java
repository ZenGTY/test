package org.hospital.service.impl;

import org.hospital.dao.BillProjectDao;
import org.hospital.entity.BillProject;
import org.hospital.service.BillProjectService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by pismery on 2017-10-25.
 */
public class BillProjectServiceImpl implements BillProjectService {

    @Autowired
    private BillProjectDao bpDao;

    public BillProject getBillById(Long id) {
        return bpDao.get(id);
    }

    public BillProject addBill(BillProject entity) {
        return bpDao.merge(entity);
    }

    public BillProject updateBill(BillProject entity) {
        return bpDao.merge(entity);
    }
}

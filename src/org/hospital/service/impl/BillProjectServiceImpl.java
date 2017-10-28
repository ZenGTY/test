package org.hospital.service.impl;

import com.alibaba.fastjson.JSON;
import com.mysql.jdbc.log.Log;

import org.hospital.domain.BillProject;
import org.hospital.domain.BillProjectDAO;
import org.hospital.domain.BillProjectId;
import org.hospital.service.BillProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pismery on 2017-10-25.
 */
@Service
@Transactional
public class BillProjectServiceImpl implements BillProjectService {

	@Autowired
	private BillProjectDAO bpDao;

	@Override
	public BillProject getByPk(BillProjectId pk) {
		return bpDao.findById(pk);
	}

	@Override
	public BillProject addEntity(BillProject entity) {
		return bpDao.merge(entity);

	}

	@Override
	public BillProject updateEntity(BillProject entity) {
		return bpDao.merge(entity);
	}

	@Override
	public List<BillProject> addEntityList(List<BillProject> bpList) {
		List<BillProject> result = new ArrayList<BillProject>();
		for (int i = 0; i < bpList.size(); i++) {
			result.add(addEntity(bpList.get(i)));
		}
		return result;
	}

}

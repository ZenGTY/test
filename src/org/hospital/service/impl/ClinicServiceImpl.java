package org.hospital.service.impl;

import java.util.List;

import org.hospital.domain.Clinic;
import org.hospital.domain.ClinicDAO;
import org.hospital.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by pismery on 2017-10-25.
 */
@Service
@Transactional
public class ClinicServiceImpl implements ClinicService{

	@Autowired
	ClinicDAO cDao;
	
	@Override
	public Clinic getById(Integer id) {
		return cDao.findById(id);
	}

	@Override
	public Clinic addEntity(Clinic entity) {
		return cDao.merge(entity);
	}

	@Override
	public Clinic updateEntity(Clinic entity) {
		return cDao.merge(entity);
	}

	@Override
	public List<Clinic> getAll() {
		return cDao.findAll();
	}
}

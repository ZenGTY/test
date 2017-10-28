package org.hospital.service.impl;

import java.util.List;

import org.hospital.domain.ClinicDAO;
import org.hospital.domain.Department;
import org.hospital.domain.DepartmentDAO;
import org.hospital.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by pismery on 2017-10-25.
 */
@Service
@Transactional
public class   DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentDAO dDao;
	@Autowired
	private ClinicDAO cDao;
	
	@Override
	public Department getById(Integer id) {
		return dDao.findById(id);
	}

	@Override
	public Department addEntity(Department entity) {
		return dDao.merge(entity);
	}

	@Override
	public Department updateEntity(Department entity) {
		return dDao.merge(entity);
	}

	@Override
	public List<Department> getByClinic(Integer clinicId) {
		return dDao.findByProperty("clinic", cDao.findById(clinicId));
		
	}
}

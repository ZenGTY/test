package org.hospital.service.impl;

import org.hospital.controller.Constant;
import org.hospital.domain.Clinic;
import org.hospital.domain.ClinicDAO;
import org.hospital.domain.Department;
import org.hospital.domain.DepartmentDAO;
import org.hospital.domain.Employee;
import org.hospital.domain.EmployeeDAO;
import org.hospital.domain.Permission;
import org.hospital.domain.PermissionDAO;
import org.hospital.domain.Position;
import org.hospital.domain.PositionDAO;
import org.hospital.domain.PositionPermission;
import org.hospital.domain.PositionPermissionDAO;
import org.hospital.service.EmployeeService;
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
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDAO eDao;
	@Autowired
	private DepartmentDAO dpmDao;
	@Autowired
	private ClinicDAO cDao;
	@Autowired
	private PositionPermissionDAO ppDao;
	@Autowired
	private PositionDAO psDao;
	@Autowired
	private PermissionDAO pmDao;

	@Override
	public Employee login(String account, String pwd) {

		Employee instance = new Employee();
		instance.setAccount(account);
		instance.setPwd(pwd);
		List<Employee> eList = eDao.findByExample(instance);
		if (eList == null || eList.size() == 0) {
			return null;
		}
		return eList.get(0);
	}

	@Override
	public List<Employee> getDepartmentEmployee(int departmentId) {
		return eDao.findByProperty("department", dpmDao.findById(departmentId));
	}

	@Override
	public List<Employee> getClinicEmployee(int clinicId) {
		return eDao.findByProperty("clinic", cDao.findById(clinicId));
	}

	@Override
	public List<Employee> getDepartmentDoctor(Department department) {

		// 获取具有开治疗单据的所有职位
		List<Permission> pmList = pmDao.findByName(Constant.CREATE_TREATMENT_BILL.getName());
		List<PositionPermission> ppList = ppDao.findByProperty("id.permissionId", pmList.get(0)
				.getPermissionId());

		List<Employee> result = new ArrayList<Employee>();
		for (int i = 0; i < ppList.size(); i++) {
			Position ps = psDao.findById(ppList.get(i).getId().getPositionId());
			result.addAll(eDao.getDoctorByProperty("department", department, ps));
		}

		return result;
	}

	@Override
	public List<Employee> getClinicDoctor(Clinic clinic) {
		// 获取具有开治疗单据的所有职位
		List<Permission> pmList = pmDao.findByName(Constant.CREATE_TREATMENT_BILL.getName());
		List<PositionPermission> ppList = ppDao.findByProperty("id.permissionId", pmList.get(0)
				.getPermissionId());

		List<Employee> result = new ArrayList<Employee>();
		for (int i = 0; i < ppList.size(); i++) {
			Position ps = psDao.findById(ppList.get(i).getId().getPositionId());
			result.addAll(eDao.getDoctorByProperty("clinic", clinic, ps));
		}

		return result;
	}

	@Override
	public List<Employee> getAllDoctor() {
		// 获取具有开治疗单据的所有职位
		List<Permission> pmList = pmDao.findByName(Constant.CREATE_TREATMENT_BILL.getName());
		List<PositionPermission> ppList = ppDao.findByProperty("id.permissionId", pmList.get(0)
				.getPermissionId());

		List<Employee> result = new ArrayList<Employee>();
		for (int i = 0; i < ppList.size(); i++) {
			Position ps = psDao.findById(ppList.get(i).getId().getPositionId());
			result.addAll(eDao.findByProperty("position", ps));
		}

		return result;
	}

	@Override
	public Employee getById(Long employeeId) {
		return eDao.findById(employeeId);
	}
}

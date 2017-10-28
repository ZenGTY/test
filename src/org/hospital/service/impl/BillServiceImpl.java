package org.hospital.service.impl;

import java.util.List;

import org.hospital.domain.Bill;
import org.hospital.domain.BillDAO;
import org.hospital.domain.Clinic;
import org.hospital.domain.Department;
import org.hospital.domain.Employee;
import org.hospital.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by pismery on 2017-10-24.
 */
@Service
public class BillServiceImpl implements BillService {

	@Autowired
	private BillDAO billDao;

	@Override
	public Bill getBillById(Long id) {
		return billDao.findById(id);
	}

	@Override
	public Bill addBill(Bill entity) {
		return billDao.merge(entity);
	}

	@Override
	public Bill updateBill(Bill entity) {
		return billDao.merge(entity);
	}

	@Override
	public void saveBill(Bill entity) {
		billDao.save(entity);
	}

	@Override
	public JSONArray getDoctorReportMsg(List<Employee> eList, Long startTime, Long endTime) {

		JSONArray resultJA = new JSONArray();
		for (int i = 0; i < eList.size(); i++) {
			JSONObject resultJO = new JSONObject();
			Employee e = eList.get(i);
			List infoList = billDao.getDoctorReportMsg(e.getEmployeeId(), startTime, endTime);
			Object[] objects = (Object[]) infoList.get(0);
			System.out.println("getDoctorReportMsg : " + JSON.toJSONString(objects));
			if (objects[0] == null) {
				resultJO.put("employeeId", e.getEmployeeId());
				resultJO.put("employeeName", e.getName());
				resultJO.put("sumNumber", 0L);
				resultJO.put("sumPrice", 0.0);

				resultJA.add(resultJO);
				continue;
			}
			resultJO.put("employeeId", e.getEmployeeId());
			resultJO.put("employeeName", e.getName());
			resultJO.put("sumNumber", objects[2]);
			resultJO.put("sumPrice", objects[3]);
			resultJA.add(resultJO);
		}

		return resultJA;
	}

	@Override
	public JSONObject getDepartmentSumPrice(Department department, Long startTime, Long endTime) {
		JSONObject result = new JSONObject();

		List infoList = billDao.getDepartmentDoctorSumPrice(department.getDepartmentId(),
				startTime, endTime);
		Object[] objects = (Object[]) infoList.get(0);

		Long sumNumber = (Long) objects[0];
		if (sumNumber == 0L) {
			result.put("departmentId", department.getDepartmentId());
			result.put("departmentName", department.getName());
			result.put("sumNumber", 0L);
			result.put("sumPrice", 0.0);
			return result;
		}

		result.put("departmentId", department.getDepartmentId());
		result.put("departmentName", department.getName());
		result.put("sumNumber", objects[0]);
		result.put("sumPrice", objects[1]);
		return result;
	}

	@Override
	public JSONObject getClinicSumPrice(Clinic clinic, Long startTime, Long endTime) {
		JSONObject result = new JSONObject();

		List infoList = billDao.getClinicDoctorSumPrice(clinic.getClinicId(),
				startTime, endTime);
		Object[] objects = (Object[]) infoList.get(0);

		Long sumNumber = (Long) objects[0];
		if (sumNumber == 0L) {
			result.put("clinicId", clinic.getClinicId());
			result.put("clinicName", clinic.getName());
			result.put("sumNumber", 0L);
			result.put("sumPrice", 0.0);
			return result;
		}

		result.put("clinicId", clinic.getClinicId());
		result.put("clinicName", clinic.getName());
		result.put("sumNumber", objects[0]);
		result.put("sumPrice", objects[1]);
		return result;
	}

	@Override
	public JSONObject getSumPrice(Long startTime, Long endTime) {
		JSONObject result = new JSONObject();

		List infoList = billDao.getAllDoctorSumPrice(startTime, endTime);
		Object[] objects = (Object[]) infoList.get(0);

		Long sumNumber = (Long) objects[0];
		if (sumNumber == 0L) {
			result.put("sumNumber", 0L);
			result.put("sumPrice", 0.0);
			return result;
		}

		result.put("sumNumber", objects[0]);
		result.put("sumPrice", objects[1]);
		return result;
	}

}

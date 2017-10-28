package org.hospital.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hospital.domain.ClientTreatmentInfoDAO;
import org.hospital.domain.Clinic;
import org.hospital.domain.Department;
import org.hospital.domain.Employee;
import org.hospital.object.WorkerReportInfo;
import org.hospital.service.ClientTreatmentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by pismery on 2017-10-25.
 */
@Service
@Transactional
public class ClientTreatmentInfoServiceImpl implements ClientTreatmentInfoService {

	@Autowired
	private ClientTreatmentInfoDAO ctiDao;

	@Override
	public List<WorkerReportInfo> getWorkerReportMsg(List<Employee> employeeList, Long startTime,
			Long endTime) {
		List<WorkerReportInfo> result = new ArrayList<WorkerReportInfo>();
		for (int i = 0; i < employeeList.size(); i++) {
			WorkerReportInfo wpi = new WorkerReportInfo();
			Employee e = employeeList.get(i);
			List infoList = ctiDao.getWorkerReportMsg(e.getEmployeeId(), startTime, endTime);
			Object[] objects = (Object[]) infoList.get(0);

			if (objects[0] == null) {
				// 如果该employee 执行治疗次数为0
				wpi.setEmployeeId(e.getEmployeeId());
				wpi.setEmployeeName(e.getName());
				wpi.setSumNumber(0L);
				wpi.setSumPrice(0.0);

				result.add(wpi);
				continue;
			}

			wpi.setEmployeeId(e.getEmployeeId());
			wpi.setEmployeeName(e.getName());
			wpi.setSumNumber((Long) objects[1]);
			wpi.setSumPrice((Double) objects[2]);
			result.add(wpi);
		}
		/*
		 * System.out.println(
		 * "ClientTreatmentInfoServiceImpl.getWorkerReportMsg.result : " +
		 * JSON.toJSONString(result));
		 */
		return result;
	}

	@Override
	public JSONObject getDepartmentSumPrice(Department department, Long startTime, Long endTime) {
		JSONObject result = new JSONObject();

		List infoList = ctiDao.getDepartmentSumPrice(department.getDepartmentId(), startTime,
				endTime);
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

		List infoList = ctiDao.getClinicSumPrice(clinic.getClinicId(), startTime, endTime);
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

		List infoList = ctiDao.getSumPrice(startTime, endTime);
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

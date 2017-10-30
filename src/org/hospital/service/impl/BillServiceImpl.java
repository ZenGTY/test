package org.hospital.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hospital.controller.Constant;
import org.hospital.domain.Bill;
import org.hospital.domain.BillDAO;
import org.hospital.domain.Clinic;
import org.hospital.domain.Department;
import org.hospital.domain.Employee;
import org.hospital.domain.Project;
import org.hospital.domain.ProjectDAO;
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
	@Autowired
	private ProjectDAO pjDao;

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

		List infoList = billDao.getClinicDoctorSumPrice(clinic.getClinicId(), startTime, endTime);
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

	@Override
	public List<Project> getDepartmentTreatmentProject(Department department, Long startTime,
			Long endTime) {
		List<Project> result = new ArrayList<Project>();
		List infoList = billDao.getDepatmentTreatmentProject(department.getDepartmentId(),
				startTime, endTime);
		for (int i = 0; i < infoList.size(); i++) {

			Long projectId = (Long) infoList.get(i);
			Project pj = pjDao.findById(projectId);
			result.add(pj);
		}
		System.out.println("BillServiceImpl.getDepartmentTreatmentProject.infoList"
				+ JSON.toJSONString(infoList));
		return result;
	}

	@Override
	public JSONArray getAllProjectReportMsg(List<Project> pjList, Long startTime, Long endTime,
			String category) {
		JSONArray resultJA = new JSONArray();
		for (int i = 0; i < pjList.size(); i++) {
			Project pj = pjList.get(i);
			List infoList = billDao.getAllProjectMsg(pj.getProjectId(), startTime, endTime,
					category);
			Object[] objects = (Object[]) infoList.get(0);
			JSONObject resultJO = new JSONObject();

			Long sumNumber = (Long) objects[0];
			if (sumNumber == 0L) {
				resultJO.put("projectId", pj.getProjectId());
				resultJO.put("projectName", pj.getName());
				resultJO.put("billNumber", 0L);
				resultJO.put("sumNumber", 0);
				resultJO.put("sumPrice", 0.0);

				resultJA.add(resultJO);
				continue;
			}

			resultJO.put("projectId", pj.getProjectId());
			resultJO.put("projectName", pj.getName());
			resultJO.put("billNumber", objects[0]);
			resultJO.put("sumNumber", objects[1]);
			resultJO.put("sumPrice", objects[2]);
			resultJA.add(resultJO);
		}

		return resultJA;
	}

	@Override
	public JSONArray getDepartmentProjectReportMsg(List<Project> pjList, Long startTime,
			Long endTime, String category, Integer departmentId) {
		JSONArray resultJA = new JSONArray();
		for (int i = 0; i < pjList.size(); i++) {
			Project pj = pjList.get(i);
			List infoList = billDao.getDepartmentProjectMsg(departmentId, pj.getProjectId(), startTime, endTime, category);
			Object[] objects = (Object[]) infoList.get(0);
			JSONObject resultJO = new JSONObject();

			Long sumNumber = (Long) objects[0];
			if (sumNumber == 0L) {
				resultJO.put("projectId", pj.getProjectId());
				resultJO.put("projectName", pj.getName());
				resultJO.put("billNumber", 0L);
				resultJO.put("sumNumber", 0);
				resultJO.put("sumPrice", 0.0);

				resultJA.add(resultJO);
				continue;
			}

			resultJO.put("projectId", pj.getProjectId());
			resultJO.put("projectName", pj.getName());
			resultJO.put("billNumber", objects[0]);
			resultJO.put("sumNumber", objects[1]);
			resultJO.put("sumPrice", objects[2]);
			resultJA.add(resultJO);
		}

		return resultJA;
	}

	@Override
	public JSONArray getClinicProjectReportMsg(List<Project> pjList, Long startTime, Long endTime,
			String category, Integer clinicId) {
		JSONArray resultJA = new JSONArray();
		for (int i = 0; i < pjList.size(); i++) {
			Project pj = pjList.get(i);
			List infoList = billDao.getClinicProjectMsg(clinicId, pj.getProjectId(), startTime, endTime, category);
			Object[] objects = (Object[]) infoList.get(0);
			JSONObject resultJO = new JSONObject();

			Long sumNumber = (Long) objects[0];
			if (sumNumber == 0L) {
				resultJO.put("projectId", pj.getProjectId());
				resultJO.put("projectName", pj.getName());
				resultJO.put("billNumber", 0L);
				resultJO.put("sumNumber", 0);
				resultJO.put("sumPrice", 0.0);

				resultJA.add(resultJO);
				continue;
			}

			resultJO.put("projectId", pj.getProjectId());
			resultJO.put("projectName", pj.getName());
			resultJO.put("billNumber", objects[0]);
			resultJO.put("sumNumber", objects[1]);
			resultJO.put("sumPrice", objects[2]);
			resultJA.add(resultJO);
		}

		return resultJA;
	}

	@Override
	public List<Project> getClinicTreatmentProject(Clinic clinic, Long startTime, Long endTime) {
		List<Project> result = new ArrayList<Project>();
		List infoList = billDao.getClinicTreatmentProject(clinic.getClinicId(), startTime, endTime);
		for (int i = 0; i < infoList.size(); i++) {
			Long projectId = (Long) infoList.get(i);
			Project pj = pjDao.findById(projectId);
			result.add(pj);
		}
		System.out.println("BillServiceImpl.getClinicTreatmentProject.result"
				+ JSON.toJSONString(result));
		return result;
	}

	@Override
	public JSONObject getSumPrice(JSONArray incomeJA, JSONArray costJA, JSONArray treatmentJA) {
		JSONObject result = new JSONObject();
		Double sumIncome = 0.0;
		Double sumCost = 0.0;
		for (int i = 0; i < incomeJA.size(); i++) {
			JSONObject incomeJO = incomeJA.getJSONObject(i);
			sumIncome += incomeJO.getDouble("sumPrice");
		}
		for (int i = 0; i < costJA.size(); i++) {
			JSONObject costJO = costJA.getJSONObject(i);
			sumCost += costJO.getDouble("sumPrice");
		}
		for (int i = 0; i < treatmentJA.size(); i++) {
			JSONObject treatmentJO = treatmentJA.getJSONObject(i);
			sumIncome += treatmentJO.getDouble("sumPrice");
		}

		result.put("sumIncome", sumIncome);
		result.put("sumCost", sumCost);
		result.put("profit", sumIncome - sumCost);
		return result;
	}

	@Override
	public List<Project> getDepartmentIncomeFundProject(Department department, Long startTime,
			Long endTime) {
		List<Project> result = new ArrayList<Project>();
		List infoList = billDao.getDepartmentFundProject(department.getDepartmentId(), startTime,
				endTime, (short) 0);
		for (int i = 0; i < infoList.size(); i++) {
			Long projectId = (Long) infoList.get(i);
			Project pj = pjDao.findById(projectId);
			result.add(pj);
		}

		/*
		 * System.out.println(
		 * "BillServiceImpl.getDepartmentIncomeFundProject.infoList : " +
		 * JSON.toJSONString(infoList));
		 */
		return result;
	}

	@Override
	public List<Project> getDepartmentCostFundProject(Department department, Long startTime,
			Long endTime) {
		List<Project> result = new ArrayList<Project>();
		List infoList = billDao.getDepartmentFundProject(department.getDepartmentId(), startTime,
				endTime, (short) 1);
		for (int i = 0; i < infoList.size(); i++) {
			Long projectId = (Long) infoList.get(i);
			Project pj = pjDao.findById(projectId);
			result.add(pj);
		}

		/*
		 * System.out.println(
		 * "BillServiceImpl.getDepartmentCostFundProject.infoList : " +
		 * JSON.toJSONString(infoList));
		 */
		return result;
	}

	@Override
	public List<Project> getClinicIncomeFundProject(Clinic clinic, Long startTime, Long endTime) {
		List<Project> result = new ArrayList<Project>();
		List infoList = billDao.getClinicFundProject(clinic.getClinicId(), startTime, endTime,
				(short) 0);
		for (int i = 0; i < infoList.size(); i++) {
			Long projectId = (Long) infoList.get(i);
			Project pj = pjDao.findById(projectId);
			result.add(pj);
		}

		System.out.println("BillServiceImpl.getClinicIncomeFundProject.infoList : "
				+ JSON.toJSONString(infoList));
		return result;
	}

	@Override
	public List<Project> getClinicCostFundProject(Clinic clinic, Long startTime, Long endTime) {
		List<Project> result = new ArrayList<Project>();
		List infoList = billDao.getClinicFundProject(clinic.getClinicId(), startTime, endTime,
				(short) 1);
		for (int i = 0; i < infoList.size(); i++) {
			Long projectId = (Long) infoList.get(i);
			Project pj = pjDao.findById(projectId);
			result.add(pj);
		}

		System.out.println("BillServiceImpl.getClinicCostFundProject.infoList : "
				+ JSON.toJSONString(infoList));
		return result;
	}

}

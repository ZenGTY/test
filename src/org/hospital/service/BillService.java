package org.hospital.service;

import java.util.List;

import org.hospital.domain.Bill;
import org.hospital.domain.Clinic;
import org.hospital.domain.Department;
import org.hospital.domain.Employee;
import org.hospital.domain.Project;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by pismery on 2017-10-24.
 */
public interface BillService {

	/**
	 * 根据Id获取Bill对象
	 * 
	 * @param id
	 * @return
	 */
	Bill getBillById(Long id);

	/**
	 * merge将Bill对象写入数据库
	 * 
	 * @param entity
	 */
	Bill addBill(Bill entity);

	/**
	 * 更新Bill
	 * 
	 * @param entity
	 * @return
	 */
	Bill updateBill(Bill entity);

	/**
	 * save将Bill对象写入数据库
	 * 
	 * @param entity
	 * @return
	 */
	void saveBill(Bill entity);

	/**
	 * 获取employeeList在[startTime,endTime]开治疗单据总次数和总价格
	 * 
	 * @param eList
	 * @param startTime
	 * @param endTime
	 * @return 
	 *         [{"employeeId":xx,"employeeName":xx,"sumNumber":xx,"sumPrice":xx},
	 *         {}]
	 */
	JSONArray getDoctorReportMsg(List<Employee> eList, Long startTime, Long endTime);

	/**
	 * 获取科室在[startTime,endTime]开治疗单据总收入、总次数
	 * 
	 * @param departmentId
	 * @param startTime
	 * @param endTime
	 * @return 
	 *         {"departmentId":xx,"departmentName":xx,"sumNumber":xx,"sumPrice":xx
	 *         }
	 */
	JSONObject getDepartmentSumPrice(Department department, Long startTime, Long endTime);

	/**
	 * 获取门诊在[startTime,endTime]开治疗单据总收入、总次数
	 * 
	 * @param clinicId
	 * @param startTime
	 * @param endTime
	 * @return {"clinicId":xx,"clinicName":xx,"sumNumber":xx,"sumPrice":xx}
	 */
	JSONObject getClinicSumPrice(Clinic clinic, Long startTime, Long endTime);

	/**
	 * 获取所有门诊在[startTime,endTime]开治疗单据总收入、总次数
	 * 
	 * @param startTime
	 * @param endTime
	 * @return {"sumNumber":xx,"sumPrice":xx}
	 */
	JSONObject getSumPrice(Long startTime, Long endTime);

	/**
	 * 获取科室开过的所有治疗项目的编号
	 * 
	 * @param departmentId
	 * @param startTime
	 * @param endTime
	 * @return [{Project对象},{}]
	 */
	List<Project> getDepartmentTreatmentProject(Department department, Long startTime, Long endTime);

	/**
	 * 获取门诊开过的所有治疗项目的编号
	 * 
	 * @param clinic
	 * @param startTime
	 * @param endTime
	 * @return [{Project对象},{}]
	 */
	List<Project> getClinicTreatmentProject(Clinic clinic, Long startTime, Long endTime);

	/**
	 * 获取指定项目 projectList 的总信息
	 * 
	 * @param pjList
	 * @param startTime
	 * @param endTime
	 * @param category
	 *            治疗单据(doctorBill) 费用单据(FundBill)
	 * @return [{"billNumber":xx,"projectId":xx,"projectName":xx,"sumNumber":xx,
	 *         "sumPrice":xx},{...}]
	 */
	JSONArray getAllProjectReportMsg(List<Project> pjList, Long startTime, Long endTime,
			String category);

	/**
	 * 获取科室下指定项目 projectList 的总信息
	 * @param pjList
	 * @param startTime
	 * @param endTime
	 * @param category 治疗单据(doctorBill) 费用单据(FundBill)
	 * @param departmentId  
	 * @return [{"billNumber":xx,"projectId":xx,"projectName":xx,"sumNumber":xx,
	 *         "sumPrice":xx},{...}]
	 */
	JSONArray getDepartmentProjectReportMsg(List<Project> pjList, Long startTime, Long endTime,
			String category, Integer departmentId);

	/**
	 * 获取门诊下指定项目 projectList 的总信息
	 * @param pjList
	 * @param startTime
	 * @param endTime
	 * @param category  治疗单据(doctorBill) 费用单据(FundBill)
	 * @param clinicId 
	 * @return [{"billNumber":xx,"projectId":xx,"projectName":xx,"sumNumber":xx,
	 *         "sumPrice":xx},{...}]
	 */
	JSONArray getClinicProjectReportMsg(List<Project> pjList, Long startTime, Long endTime,
			String category, Integer clinicId);
	
	/**
	 * 获取总额
	 * @param incomeJA  [{"billNumber":xx,"projectId":xx,"projectName":xx,"sumNumber":xx, "sumPrice":xx},{}]
	 * @param costJA [{"billNumber":xx,"projectId":xx,"projectName":xx,"sumNumber":xx, "sumPrice":xx},{}]
	 * @param treatmentJA [{"billNumber":xx,"projectId":xx,"projectName":xx,"sumNumber":xx, "sumPrice":xx},{}]
	 * @return
	 */
	JSONObject getSumPrice(JSONArray incomeJA,JSONArray costJA,JSONArray treatmentJA);
	
	List<Project> getDepartmentIncomeFundProject(Department department, Long startTime, Long endTime);

	List<Project> getDepartmentCostFundProject(Department department, Long startTime, Long endTime);

	List<Project> getClinicIncomeFundProject(Clinic clinic, Long startTime, Long endTime);

	List<Project> getClinicCostFundProject(Clinic clinic, Long startTime, Long endTime);
}

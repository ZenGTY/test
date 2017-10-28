package org.hospital.service;

import java.util.List;

import org.hospital.domain.Clinic;
import org.hospital.domain.Department;
import org.hospital.domain.Employee;
import org.hospital.object.WorkerReportInfo;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by pismery on 2017-10-25.
 */
public interface ClientTreatmentInfoService {

	/**
	 * 获取employeeId 从startTime至endTime的总次数和总价格
	 * 
	 * @param employeeList
	 * @param startTime
	 * @param endTime
	 * @return 
	 *         [{"employeeId":xx,"employeeName":xx,"sumNumber":xx,"sumPrice":xx},{}]
	 */
	List<WorkerReportInfo> getWorkerReportMsg(List<Employee> employeeList, Long startTime,
			Long endTime);

	/**
	 * 获取科室在[startTime,endTime]执行治疗总收入、总次数
	 * 
	 * @param departmentId
	 * @param startTime
	 * @param endTime
	 * @return 
	 *         {"departmentId":xx,"departmentName":xx,"sumNumber":xx,"sumPrice":xx}
	 */
	JSONObject getDepartmentSumPrice(Department department, Long startTime, Long endTime);

	/**
	 * 获取门诊在[startTime,endTime]执行治疗总收入、总次数
	 * 
	 * @param clinicId
	 * @param startTime
	 * @param endTime
	 * @return {"clinicId":xx,"clinicName":xx,"sumNumber":xx,"sumPrice":xx}
	 */
	JSONObject getClinicSumPrice(Clinic clinic, Long startTime, Long endTime);

	/**
	 * 获取所有门诊在[startTime,endTime]执行治疗总收入、总次数
	 * 
	 * @param startTime
	 * @param endTime
	 * @return {"sumNumber":xx,"sumPrice":xx}
	 */
	JSONObject getSumPrice(Long startTime, Long endTime);
}

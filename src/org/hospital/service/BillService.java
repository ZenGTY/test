package org.hospital.service;

import java.util.List;

import org.hospital.domain.Bill;
import org.hospital.domain.Clinic;
import org.hospital.domain.Department;
import org.hospital.domain.Employee;

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
	 * @return [{"employeeId":xx,"employeeName":xx,"sumNumber":xx,"sumPrice":xx},{}]
	 */
	JSONArray getDoctorReportMsg(List<Employee> eList, Long startTime, Long endTime);

	/**
	 * 获取科室在[startTime,endTime]开治疗单据总收入、总次数
	 * 
	 * @param departmentId
	 * @param startTime
	 * @param endTime
	 * @return {"departmentId":xx,"departmentName":xx,"sumNumber":xx,"sumPrice":xx}
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

}

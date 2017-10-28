package org.hospital.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hospital.domain.Clinic;
import org.hospital.domain.Department;
import org.hospital.domain.Employee;
import org.hospital.domain.Permission;
import org.hospital.domain.PositionPermission;
import org.hospital.object.WorkerReportInfo;
import org.hospital.service.BillService;
import org.hospital.service.ClientTreatmentInfoService;
import org.hospital.service.ClinicService;
import org.hospital.service.DepartmentService;
import org.hospital.service.EmployeeService;
import org.hospital.service.PositionPermissionService;
import org.hospital.service.PositionService;
import org.hospital.util.DateUtil;
import org.hospital.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("reportController")
@SessionAttributes(value = "employee", types = Employee.class)
public class ReportController {

	private static Logger log = LoggerFactory.getLogger(ReportController.class);

	@Autowired
	private PositionService psService;
	@Autowired
	private EmployeeService eService;
	@Autowired
	private ClientTreatmentInfoService ctiService;
	@Autowired
	private DepartmentService dptService;
	@Autowired
	private ClinicService cService;
	@Autowired
	private BillService bService;
	
	/**
	 * 医生开单报表
	 * @param req
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getDoctorReport", produces = "text/json;charset=utf-8")
	public String getDoctorReport(WebRequest req, HttpSession session) {
		// 参数
		// {
		// rank : xxx, (1:科室级报表;2:门诊级报表;3:企业级报表)
		// departmentId : xxx,
		// clinicId : xxx,
		// startTime : xxx,
		// endTime : xxx,
		// }

		// 获取数据
		Long startTimeLong;
		Long endTimeLong;
		int rank;
		int departmentId;
		int clinicId;

		try {
			startTimeLong = DateUtil.getShortDateLong(req.getParameter("startTime"));
			endTimeLong = DateUtil.getShortDateLong(req.getParameter("endTime"));
			rank = Integer.parseInt(req.getParameter("rank"), 10); // 报表等级(1:科室级报表；2:门诊级报表;3:企业级报表)
			departmentId = Integer.parseInt(req.getParameter("departmentId"), 10);
			clinicId = Integer.parseInt(req.getParameter("clinicId"), 10);

			if (rank < 1 || rank > 3) {
				return StringUtil.setResult(401, "rank参数有误", "");
			}
		} catch (Exception e) {
			return StringUtil.setResult(401, "参数有误", "");
		}

		// 验证用户权限
		Employee e = (Employee) session.getAttribute("employee");
		if (e == null) {
			return StringUtil.setResult(405, "请重新登录", "");
		}

		if (!psService.isPermisionEnough(e.getPosition().getPositionId(),
				Constant.GET_REPORT.getName(), rank + 1)) {
			return StringUtil.setResult(402, "权限不足", "");
		}

		// 科室级报表
		if (rank == 1) {
			Department department;
			if (e.getPosition().getRank() == 2) {
				department = e.getDepartment();
			} else {
				department = dptService.getById(departmentId);
				if (department == null) {
					return StringUtil.setResult(401, "departmentId 不存在", "");
				}
			}
			// 获取科室医生
			List<Employee> eList = eService.getDepartmentDoctor(department);

			// 获取医生开单情况
			// [{"employeeId":1,"employeeName":"pismery","sumNumber":15,"sumPrice":6750}]
			JSONArray rowInfosJA = bService.getDoctorReportMsg(eList, startTimeLong, endTimeLong);
			System.out.println("ReportController.getDoctorReport.rowInfosJA : "
					+ rowInfosJA.toJSONString());
			// 获取科室总情况
			// {"departmentId":1,"departmentName":"科室一","sumNumber":15,"sumPrice":6750}
			JSONObject resultJO = bService.getDepartmentSumPrice(department, startTimeLong,
					endTimeLong);

			resultJO.put("rowInfos", rowInfosJA);
			System.out.println("ReportController.getDoctorReport.resultJO : "
					+ resultJO.toJSONString());

			return StringUtil.setResult(200, "获取成功", resultJO.toJSONString());

			// 结果显示
			// result : {
			// "departmentId":1,
			// "departmentName":"科室一",
			// "sumNumber":15,
			// "sumPrice":6750
			// "rowInfos":[{
			// "employeeId":1,
			// "employeeName":"pismery",
			// "sumNumber":15,
			// "sumPrice":6750}]
			// }

		}

		// 门诊级别
		if (rank == 2) {
			Clinic clinic;
			if (e.getPosition().getRank() == 3) {
				clinic = e.getClinic();
			} else {
				clinic = cService.getById(clinicId);
				if (clinic == null) {
					return StringUtil.setResult(401, "clinicId 不存在", "");
				}
			}

			// 获取门诊下所有科室
			List<Department> dpmList = dptService.getByClinic(clinic.getClinicId());

			// 获取各部门总情况
			JSONArray rowInfosJA = new JSONArray();
			for (int i = 0; i < dpmList.size(); i++) {
				JSONObject rowInfosJO = bService.getDepartmentSumPrice(dpmList.get(i),
						startTimeLong, endTimeLong);
				rowInfosJA.add(rowInfosJO);
			}

			// 获取门诊总情况
			// {"clinicId":1,"clinicName":"门诊一","sumNumber":15,"sumPrice":6750}
			JSONObject resultJO = bService.getClinicSumPrice(clinic, startTimeLong, endTimeLong);

			resultJO.put("rowInfos", rowInfosJA);
			System.out.println("ReportController.getDoctorReport.resultJO2 : "
					+ resultJO.toJSONString());

			return StringUtil.setResult(200, "获取成功", resultJO.toJSONString());
			// 返回参数例子：
			// {
			// "code":200,
			// "msg":"获取成功",
			// "result":{}
			// }
			// result:
			// {
			// "clinicId:1,
			// "clinicName:门诊一,
			// "sumNumber":3,
			// "sumPrice":60,
			// rowInfosos":[{"departmentId":1,"departmentName":"pismery","sumNumber":2,"sumPrice":35},{...},...]
			// }
		}

		// 企业级报表
		List<Clinic> cList = cService.getAll();
		JSONArray rowInfosJA = new JSONArray();
		for (int i = 0; i < cList.size(); i++) {
			JSONObject rowInfosJO = bService.getClinicSumPrice(cList.get(i), startTimeLong,
					endTimeLong);
			rowInfosJA.add(rowInfosJO);
		}
		JSONObject resultJO = bService.getSumPrice(startTimeLong, endTimeLong);
		resultJO.put("rowInfos", rowInfosJA);
		System.out.println("ReportController.getDoctorReport.resultJO3 : "
				+ resultJO.toJSONString());

		return StringUtil.setResult(200, "获取成功", resultJO.toJSONString());
		// 返回参数例子：
		// {
		// "code":200,
		// "msg":"获取成功",
		// "result":{}
		// }
		// result:
		// {
		// "sumNumber":3,
		// "sumPrice":60,
		// "rowInfos":[{"clinicId":1,"clinicName":"pismery","sumNumber":2,"sumPrice":35},{...},...]
		// }
	}
	
	/**
	 * 科室总报表
	 * @param req
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getDepartmentReport", produces = "text/json;charset=utf-8")
	public String getDepartmentReport(WebRequest req, HttpSession session) {
		return null;
	}
	
	/**
	 * 门诊总报表
	 * @param req
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getClinicReport", produces = "text/json;charset=utf-8")
	public String getClinicReport(WebRequest req, HttpSession session) {
		psService.getByPermission(new Permission());
		// List<Employee> eList =
		// eService.getDepartmentDoctor(dptService.getById(2));
		List<Employee> eList = eService.getAllDoctor();
		System.out.println("-----eList : " + eList.get(0).getName() + "," + eList.get(1).getName());
		return null;
	}

	/**
	 * 查看执行者报表
	 * 
	 * @param req
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getWorkerReport", produces = "text/json;charset=utf-8")
	public String getWorkerReport(WebRequest req, HttpSession session) {
		// 参数
		// {
		// rank : xxx, (1:科室级报表；2:门诊级报表;3:企业级报表)
		// departmentId : xxx,
		// clinicId : xxx,
		// startTime : xxx,
		// endTime : xxx,
		// }

		// 获取数据
		Long startTimeLong;
		Long endTimeLong;
		int rank;
		int departmentId;
		int clinicId;

		try {
			startTimeLong = DateUtil.getShortDateLong(req.getParameter("startTime"));
			endTimeLong = DateUtil.getShortDateLong(req.getParameter("endTime"));
			rank = Integer.parseInt(req.getParameter("rank"), 10); // 报表等级(1:科室级报表；2:门诊级报表;3:企业级报表)
			departmentId = Integer.parseInt(req.getParameter("departmentId"), 10);
			clinicId = Integer.parseInt(req.getParameter("clinicId"), 10);

			if (rank < 1 || rank > 3) {
				return StringUtil.setResult(401, "rank参数有误", "");
			}
		} catch (Exception e) {
			return StringUtil.setResult(401, "参数有误", "");
		}

		// 验证用户权限
		Employee e = (Employee) session.getAttribute("employee");
		if (e == null) {
			return StringUtil.setResult(405, "请重新登录", "");
		}

		if (!psService.isPermisionEnough(e.getPosition().getPositionId(),
				Constant.GET_REPORT.getName(), rank + 1)) {
			return StringUtil.setResult(402, "权限不足", "");
		}

		// 科室级报表
		if (rank == 1) {
			Department department;

			if (e.getPosition().getRank() == 2) {
				department = e.getDepartment();
			} else {
				department = dptService.getById(departmentId);
				if (department == null) {
					return StringUtil.setResult(401, "departmentId 不存在", "");
				}
			}
			List<Employee> eList = eService.getDepartmentEmployee(department.getDepartmentId());
			System.out.println("eList : " + JSON.toJSONString(eList));

			// 获取[{"employeeId":1,"employeeName":"pismery","sumNumber":2,"sumPrice":35},{...},...]
			List<WorkerReportInfo> workInfoList = ctiService.getWorkerReportMsg(eList,
					startTimeLong, endTimeLong);

			// 获取{"sumNumber":3,"sumPrice":60}
			JSONObject resultJO = ctiService.getDepartmentSumPrice(department, startTimeLong,
					endTimeLong);

			resultJO.put("rowInfos", workInfoList);

			System.out.println("ReportController.getWorkerReport.resultJO1 : "
					+ resultJO.toJSONString());
			return StringUtil.setResult(200, "获取成功", resultJO.toJSONString());

			// 返回参数例子：
			// {
			// "code":200,
			// "msg":"获取成功",
			// "result":{}
			// }
			// result:
			// {
			// "departmentId:1,
			// "departmentName:科室一,
			// "sumNumber":3,
			// "sumPrice":60,
			// "rowInfos":[{"employeeId":1,"employeeName":"pismery","sumNumber":2,"sumPrice":35},{...},...]
			// }

		}

		// 门诊级别报表
		if (rank == 2) {
			Clinic clinic;
			if (e.getPosition().getRank() == 3) {
				clinic = e.getClinic();
			} else {
				clinic = cService.getById(clinicId);
				if (clinic == null) {
					return StringUtil.setResult(401, "clinicId 不存在", "");
				}
			}
			List<Department> dpmList = dptService.getByClinic(clinic.getClinicId());

			// 获取[{"departmentId":1,"departmentName":"pismery","sumNumber":2,"sumPrice":35},{...},...]
			JSONArray rowInfosJA = new JSONArray();
			for (int i = 0; i < dpmList.size(); i++) {
				Department department = dpmList.get(i);
				JSONObject rowInfosJO = ctiService.getDepartmentSumPrice(department, startTimeLong,
						endTimeLong);
				rowInfosJA.add(rowInfosJO);
			}

			JSONObject resultJO = ctiService.getClinicSumPrice(clinic, startTimeLong, endTimeLong);
			resultJO.put("rowInfos", rowInfosJA);

			System.out.println("ReportController.getWorkerReport.resultJO2 : "
					+ resultJO.toJSONString());
			return StringUtil.setResult(200, "获取成功", resultJO.toJSONString());
			// 返回参数例子：
			// {
			// "code":200,
			// "msg":"获取成功",
			// "result":{}
			// }
			// result:
			// {
			// "clinicId:1,
			// "clinicName:门诊一,
			// "sumNumber":3,
			// "sumPrice":60,
			// rowInfosos":[{"departmentId":1,"departmentName":"pismery","sumNumber":2,"sumPrice":35},{...},...]
			// }

		}

		// 企业级报表
		List<Clinic> cList = cService.getAll();

		JSONArray rowInfosJA = new JSONArray();
		for (int i = 0; i < cList.size(); i++) {
			Clinic clinic = cList.get(i);
			JSONObject rowInfosJO = ctiService
					.getClinicSumPrice(clinic, startTimeLong, endTimeLong);
			rowInfosJA.add(rowInfosJO);
		}
		JSONObject resultJO = ctiService.getSumPrice(startTimeLong, endTimeLong);
		resultJO.put("rowInfos", rowInfosJA);

		System.out.println("ReportController.getWorkerReport.resultJO2 : "
				+ resultJO.toJSONString());
		return StringUtil.setResult(200, "获取成功", resultJO.toJSONString());
		// 返回参数例子：
		// {
		// "code":200,
		// "msg":"获取成功",
		// "result":{}
		// }
		// result:
		// {
		// "sumNumber":3,
		// "sumPrice":60,
		// "rowInfos":[{"clinicId":1,"clinicName":"pismery","sumNumber":2,"sumPrice":35},{...},...]
		// }
	}
}

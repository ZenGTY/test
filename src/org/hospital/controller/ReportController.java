package org.hospital.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hospital.domain.Clinic;
import org.hospital.domain.Department;
import org.hospital.domain.Employee;
import org.hospital.domain.Project;
import org.hospital.object.WorkerReportInfo;
import org.hospital.service.BillService;
import org.hospital.service.ClientTreatmentInfoService;
import org.hospital.service.ClinicService;
import org.hospital.service.DepartmentService;
import org.hospital.service.EmployeeService;
import org.hospital.service.PositionService;
import org.hospital.service.ProjectService;
import org.hospital.util.DateUtil;
import org.hospital.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
	@Autowired
	private ProjectService pjService;

	/**
	 * 医生开单报表
	 * 
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
	 * 获取治疗项目报表
	 * 
	 * @param req
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/getProjectReport", produces = "text/json;charset=utf-8")
	public String getProjectReport(WebRequest req, HttpSession session, ModelMap model) {
		// 参数
		// {
		// rank : xxx, (1:科室级报表;2:门诊级报表;3:企业级报表)
		// departmentId : xxx,
		// clinicId : xxx,
		// startTime : xxx,
		// endTime : xxx,
		// }

		// TODO 错误如何返回

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

			// 获取科室开过的所有治疗项目
			List<Project> pjList = bService.getDepartmentTreatmentProject(department,
					startTimeLong, endTimeLong);
			System.out.println("ReportController.getProjectReport.pjList : " + pjList.size());

			// 获取各个治疗项目信息
			JSONArray rowInfosJA = bService.getDepartmentProjectReportMsg(pjList, startTimeLong,
					endTimeLong, Constant.DOCTOR_BILL.getName(), department.getDepartmentId());
			// System.out.println("ReportController.getProjectReport.rowInfosJA : "+JSON.toJSONString(rowInfosJA));

			// 获取部门统计信息
			JSONObject resultJO = bService.getDepartmentSumPrice(department, startTimeLong,
					endTimeLong);
			// System.out.println("ReportController.getProjectReport.resultJO : "+JSON.toJSONString(resultJO));

			model.addAttribute("rowsInfo", rowInfosJA);
			model.addAttribute("totalInfo", resultJO);

			// TODO 转发到相应页面
			return "forward:/getProjectReport.jsp";
		}

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

			// 获取门诊开过的治疗项目
			List<Project> pjList = bService.getClinicTreatmentProject(clinic, startTimeLong,
					endTimeLong);
			// for (int i = 0; i < pjList.size(); i++) {
			// System.out.println("ReportController.getProjectReport.pjList.name : "+pjList.get(i).getName());
			// }
			// 获取各个治疗项目信息
			JSONArray rowInfosJA = bService.getClinicProjectReportMsg(pjList, startTimeLong,
					endTimeLong, Constant.DOCTOR_BILL.getName(), clinic.getClinicId());

			// 获取门诊统计信息
			JSONObject resultJO = bService.getClinicSumPrice(clinic, startTimeLong, endTimeLong);
			System.out.println("ReportController.getProjectReport.rowInfosJA : "
					+ JSON.toJSONString(rowInfosJA, true));
			System.out.println("ReportController.getProjectReport.resultJO : "
					+ JSON.toJSONString(resultJO, true));

			model.addAttribute("rowsInfo", rowInfosJA);
			model.addAttribute("totalInfo", resultJO);

			// TODO 转发到相应页面
			return "forward:/getProjectReport.jsp";
		}

		// 企业级
		// 获取所有治疗项目
		List<Project> pjList = pjService.getTreatmentProject();
		// 获取各个治疗项目信息
		JSONArray rowInfosJA = bService.getAllProjectReportMsg(pjList, startTimeLong, endTimeLong,
				Constant.DOCTOR_BILL.getName());
		JSONObject resultJO = bService.getSumPrice(startTimeLong, endTimeLong);
		System.out.println("ReportController.getProjectReport.rowInfosJA : "
				+ JSON.toJSONString(rowInfosJA, true));
		System.out.println("ReportController.getProjectReport.resultJO : "
				+ JSON.toJSONString(resultJO, true));

		model.addAttribute("rowsInfo", rowInfosJA);
		model.addAttribute("totalInfo", resultJO);

		// TODO 转发到相应页面
		return "forward:/getProjectReport.jsp";
	}

	/**
	 * 科室总报表
	 * 
	 * @param req
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/getDepartmentReport", produces = "text/json;charset=utf-8")
	public String getDepartmentReport(WebRequest req, HttpSession session, ModelMap model) {
		// 参数
		// {
		// departmentId : xxx,
		// startTime : xxx,
		// endTime : xxx,
		// }

		// TODO 错误如何返回

		// 获取数据
		Long startTimeLong;
		Long endTimeLong;
		int departmentId;
		try {
			startTimeLong = DateUtil.getShortDateLong(req.getParameter("startTime"));
			endTimeLong = DateUtil.getShortDateLong(req.getParameter("endTime"));
			departmentId = Integer.parseInt(req.getParameter("departmentId"), 10);
		} catch (Exception e) {
			return StringUtil.setResult(401, "参数有误", "");
		}

		// 验证用户权限
		Employee e = (Employee) session.getAttribute("employee");
		if (e == null) {
			return StringUtil.setResult(405, "请重新登录", "");
		}
		// 获取数据库是中最新的用户信息 用session的数据库修改了 没有更新
		Employee employee = eService.getById(e.getEmployeeId());
		// 如果查询的不是本部门的报表则需要门诊级别的职位
		if (departmentId != employee.getDepartment().getDepartmentId()
				&& !psService.isPermisionEnough(employee.getPosition().getPositionId(),
						Constant.GET_REPORT.getName(), 3)) {
			return StringUtil.setResult(402, "权限不足", "");
		}
		// 如果查询的是本部门的报表则需要部门级别的职位
		if (!psService.isPermisionEnough(employee.getPosition().getPositionId(),
				Constant.GET_REPORT.getName(), 2)) {
			return StringUtil.setResult(402, "权限不足", "");
		}

		/*
		 * 1、分别获取所有开过的 收入费用项目、所有支出费用项目、所有治疗项目； 2、查询收入费用项目明细、总和； 3、查询支出费用项目明细、总和；
		 * 4、查询治疗项目总和； 5、计算总利润、总支出、总收入
		 */
		Department department = dptService.getById(departmentId);
		List<Project> incomePjList = bService.getDepartmentIncomeFundProject(department,
				startTimeLong, endTimeLong);
		List<Project> costPjList = bService.getDepartmentCostFundProject(department, startTimeLong,
				endTimeLong); // System.out.println("ReportController.getDepartmentReport.pjList : "+JSON.toJSONString(pjList));
		List<Project> treatmentPjList = bService.getDepartmentTreatmentProject(department,
				startTimeLong, endTimeLong);

		JSONArray incomeRowsInfo = bService.getDepartmentProjectReportMsg(incomePjList,
				startTimeLong, endTimeLong, Constant.FUND_BILL.getName(),
				department.getDepartmentId());

		JSONArray costRowsInfo = bService.getDepartmentProjectReportMsg(costPjList, startTimeLong,
				endTimeLong, Constant.FUND_BILL.getName(), department.getDepartmentId());

		JSONArray treatmentRowsInfo = bService.getDepartmentProjectReportMsg(treatmentPjList,
				startTimeLong, endTimeLong, Constant.DOCTOR_BILL.getName(),
				department.getDepartmentId());

		JSONObject sumJO = bService.getSumPrice(incomeRowsInfo, costRowsInfo, treatmentRowsInfo);

		incomeRowsInfo.add(getTreatmentSumJO(treatmentRowsInfo));

		model.addAttribute("incomeRowsInfo", incomeRowsInfo);
		model.addAttribute("costRowsInfo", costRowsInfo);
		model.addAttribute("sumInfo", sumJO);

		return "forward:/getDepartmentReport.jsp";
	}

	/**
	 * 门诊总报表
	 * 
	 * @param req
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/getClinicReport", produces = "text/json;charset=utf-8")
	public String getClinicReport(WebRequest req, HttpSession session, ModelMap model) {
		// 参数
		// {
		// clinicId : xxx,
		// startTime : xxx,
		// endTime : xxx,
		// }

		// 获取数据
		Long startTimeLong;
		Long endTimeLong;
		int clinicId;
		try {
			startTimeLong = DateUtil.getShortDateLong(req.getParameter("startTime"));
			endTimeLong = DateUtil.getShortDateLong(req.getParameter("endTime"));
			clinicId = Integer.parseInt(req.getParameter("clinicId"), 10);
		} catch (Exception e) {
			return StringUtil.setResult(401, "参数有误", "");
		}

		// 验证用户权限
		Employee e = (Employee) session.getAttribute("employee");
		if (e == null) {
			return StringUtil.setResult(405, "请重新登录", "");
		}
		// 获取数据库是中最新的用户信息 用session的数据库修改了 没有更新
		Employee employee = eService.getById(e.getEmployeeId());
		// 如果查询的不是本门诊的报表则需要企业级别的职位
		if (clinicId != employee.getClinic().getClinicId()
				&& !psService.isPermisionEnough(employee.getPosition().getPositionId(),
						Constant.GET_REPORT.getName(), 4)) {
			return StringUtil.setResult(402, "权限不足", "");
		}
		// 如果查询的是本门诊的报表则需要门诊级别的职位
		if (!psService.isPermisionEnough(employee.getPosition().getPositionId(),
				Constant.GET_REPORT.getName(), 3)) {
			return StringUtil.setResult(402, "权限不足", "");
		}

		Clinic clinic = cService.getById(clinicId);
		//获取门诊开过的收入费用项目、支出费用项目、治疗项目
		List<Project> incomePjList = bService.getClinicIncomeFundProject(clinic, startTimeLong,
				endTimeLong);
		List<Project> costPjList = bService.getClinicCostFundProject(clinic, startTimeLong,
				endTimeLong);
		List<Project> treatmentPjList = bService.getClinicTreatmentProject(clinic, startTimeLong,
				endTimeLong);
		
		//获取门诊开过的收入费用项目、支出费用项目、治疗项目的汇总信息
		JSONArray incomeRowsInfo = bService.getClinicProjectReportMsg(incomePjList, startTimeLong,
				endTimeLong, Constant.FUND_BILL.getName(), clinic.getClinicId());
		JSONArray costRowsInfo = bService.getClinicProjectReportMsg(costPjList, startTimeLong,
				endTimeLong, Constant.FUND_BILL.getName(), clinic.getClinicId());
		JSONArray treatmentRowsInfo = bService.getClinicProjectReportMsg(treatmentPjList,
				startTimeLong, endTimeLong, Constant.DOCTOR_BILL.getName(), clinic.getClinicId());

		JSONObject sumJO = bService.getSumPrice(incomeRowsInfo, costRowsInfo, treatmentRowsInfo);

		incomeRowsInfo.add(getTreatmentSumJO(treatmentRowsInfo));

		model.addAttribute("incomeRowsInfo", incomeRowsInfo);
		model.addAttribute("costRowsInfo", costRowsInfo);
		model.addAttribute("sumInfo", sumJO);

		return "forward:/getClinicReport.jsp";
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

	/**
	 * 
	 * @param treatmentRowsInfo
	 *            [{"billNumber":xx,"projectId":xx,"projectName":xx,"sumNumber":
	 *            xx,"sumPrice":xx},{}]
	 * @return {"billNumber":xx,"projectId":xx,"projectName":xx,"sumNumber":xx,
	 *         "sumPrice":xx}
	 */
	public JSONObject getTreatmentSumJO(JSONArray treatmentRowsInfo) {
		JSONObject result = new JSONObject();
		int billNumber = 0;
		Double sumPrice = 0.0;
		for (int i = 0; i < treatmentRowsInfo.size(); i++) {
			JSONObject rowInfo = treatmentRowsInfo.getJSONObject(i);
			billNumber += rowInfo.getIntValue("billNumber");
			sumPrice += rowInfo.getDouble("sumPrice");
		}

		result.put("billNumber", billNumber);
		result.put("sumPrice", sumPrice);
		result.put("projectId", 0L);
		result.put("projectName", "治疗项目");
		result.put("sumNumber", 0L);

		return result;
	}
}

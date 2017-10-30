package org.hospital.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import org.hospital.domain.Bill;
import org.hospital.domain.BillProject;
import org.hospital.domain.BillProjectId;
import org.hospital.domain.Client;
import org.hospital.domain.ClientTreatmentProject;
import org.hospital.domain.Employee;
import org.hospital.domain.Project;
import org.hospital.service.*;
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

import javax.servlet.http.HttpSession;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pismery on 2017-10-24.
 */
@Controller
@RequestMapping("billController")
@SessionAttributes(value = "employee", types = Employee.class)
public class BillController {

	private static Logger log = LoggerFactory.getLogger(BillController.class);

	@Autowired
	private BillService bService;
	@Autowired
	private PositionService psService;
	@Autowired
	private ClientService cService;
	@Autowired
	private BillProjectService bpService;
	@Autowired
	private ProjectService pjService;
	@Autowired
	private ClientTreatmentProjectService ctpService;
	@Autowired
	private ClinicService clinicService;
	@Autowired
	private DepartmentService depService;
	
	
	
	
	@ResponseBody
	@RequestMapping(value = "/get", produces = "text/json;charset=utf-8")
	public String get(WebRequest req) {
		Bill bill = bService.getBillById(1L);

		log.info("bill : {}", bill);
		log.debug("debug get");
		log.error("error get");
		log.trace("trace get");
		System.out.println("bill id:" + bill.getBillId() + " clientId:"
				+ bill.getClient().getClientId());
		return "Bill get2";
	}

	/**
	 * 添加治疗项目单据 参数格式 { clientId:xx, status:xx, sum:xxx,
	 * projcets:[{projectId:xx,number:xx,deadline:xx,extraInfo:xx},{}], }
	 * 
	 * @param req
	 * @param session
	 * @return 401：数据库插入错误；402：权限不足；405：session不存在，重新登陆；200：操作成功
	 */
	@ResponseBody
	@RequestMapping(value = "/addTreatmentBill", produces = "text/json;charset=utf-8")
	public String addTreatmentBill(WebRequest req, HttpSession session) {
		// 检测用户权限
		Employee e = (Employee) session.getAttribute("employee");

		if (e == null) {
			return StringUtil.setResult(405, "请重新登录", "");
		}

		if (!psService.isPermisionEnough(e.getPosition().getPositionId(),
				Constant.CREATE_TREATMENT_BILL.getName(), 1)) {
			return StringUtil.setResult(402, "权限不足", "");
		}

		// 获取数据
		Long clientId = Long.parseLong(req.getParameter("clientId"), 10);
		Short status = Short.parseShort(req.getParameter("status"), 10);
		JSONArray projects = JSONArray.parseArray(req.getParameter("projects"));
		Double totalPrice = Double.parseDouble(req.getParameter("sum"));

		System.out.println("addTreatmentBill projects : " + JSON.toJSONString(projects, false));
		// System.out.println("addTreatmentBill clientId : " + clientId);
		// System.out.println("addTreatmentBill req.getParameter(\"clientId\") : "
		// + req.getParameter("clientId"));
		Client client = cService.getById(clientId);

		// 插入bill表数据
		Bill bill = new Bill();
		bill.setClient(client);
		bill.setEmployee(e);
		bill.setDepartment(e.getDepartment());
		bill.setClinic(e.getClinic());
		bill.setCategory(Constant.DOCTOR_BILL.getName());
		bill.setTotalPrice(totalPrice);
		bill.setTotalCost(0.0);
		bill.setDatetime(new Timestamp(DateUtil.getNowLong()));
		bill.setStatus(status);

		System.out.println("addTreatmentBill bill 插入数据库前: " + bill.getBillId());
		bill = bService.addBill(bill);
		System.out.println("addTreatmentBill bill 插入数据库后: " + bill.getBillId());

		// 插入billproject表数据
		// 插入clientTreatmentProject表数据
		List<BillProject> bpList = new ArrayList<BillProject>();
		List<ClientTreatmentProject> ctpList = new ArrayList<ClientTreatmentProject>();
		for (int i = 0; i < projects.size(); i++) {
			JSONObject jo = projects.getJSONObject(i);
			System.out.println("addTreatmentBill project : " + JSON.toJSONString(jo, false));

			long projectId = jo.getLongValue("projectId");
			Project project = pjService.getById(projectId);
			short number = jo.getShortValue("number");
			double unitPrice = project.getUnitPrice();
			Timestamp deadline = new Timestamp(DateUtil.getDateLong(jo.getString("deadline")));

			// billproject表
			BillProject bProject = new BillProject();
			bProject.setId(new BillProjectId(bill.getBillId(), projectId));
			bProject.setDeadline(deadline);
			bProject.setNumber(number);
			bProject.setExtraInfo(jo.getString("extroInfo"));
			bProject.setPrice(unitPrice * number);
			bpList.add(bProject);

			// clientTreatmentProject表
			ClientTreatmentProject ctp = new ClientTreatmentProject();
			ctp.setClient(client);
			ctp.setBill(bill);
			ctp.setProject(project);
			ctp.setUnitPrice(unitPrice);
			ctp.setTotalNumber(number);
			ctp.setRestNumber(number);
			ctp.setStartTime(new Timestamp(DateUtil.getNowLong()));
			ctp.setDeadline(deadline);
			ctp.setStatus((short) 0);
			ctpList.add(ctp);

		}

		System.out.println("addTreatmentBill bpList 插入前: " + bpList.get(0).getId().getBillId());
		bpList = bpService.addEntityList(bpList);
		System.out.println("addTreatmentBill bpList 插入后: " + JSON.toJSONString(bpList, false));

		System.out.println("addTreatmentBill ctpList 插入前: " + ctpList.get(0).getBill().getBillId());
		ctpList = ctpService.addEntityList(ctpList);
		System.out.println("addTreatmentBill ctpList 插入后: " + JSON.toJSONString(ctpList, false));

		return StringUtil.setResult(200, "添加成功", "");
	}

	/**
	 * 添加费用单据 参数格式 { clientId:xxx, clinicId:xxx, departmentId:xxx, status:xxx,
	 * sum:xxx, 利润 incomeSum:xxx, 收入 paySum:xxx, 支出 submitTime, 单据所属时间
	 * 2017-01-10
	 * projects:[{markText:xxx(摘要),projectId:xxx,costType:xxx,price:xxx}], }
	 * 
	 * @param req
	 * @param session
	 * @return 401：数据库插入错误；402：权限不足；405：session不存在，重新登陆；200：操作成功
	 */
	@ResponseBody
	@RequestMapping(value = "/addFundBill", produces = "text/json;charset=utf-8")
	public String addFundBill(WebRequest req, HttpSession session) {
		// 检测用户权限
		Employee e = (Employee) session.getAttribute("employee");

		if (e == null) {
			return StringUtil.setResult(405, "请重新登录", "");
		}

		if (!psService.isPermisionEnough(e.getPosition().getPositionId(),
				Constant.CREATE_FUND_BILL.getName(), 1)) {
			return StringUtil.setResult(402, "权限不足", "");
		}

		// 获取数据
		Client client = cService.getById(Long.parseLong(req.getParameter("clientId"), 10));
		JSONArray projects = JSONArray.parseArray(req.getParameter("projects"));

		// 插入bill表
		Bill bill = new Bill();
		bill.setClient(client);
		bill.setEmployee(e);
		bill.setClinic(clinicService.getById(Integer.parseInt(req.getParameter("clinicId"), 10)));
		bill.setDepartment(depService.getById(Integer.parseInt(req.getParameter("departmentId"), 10)));
		bill.setCategory(Constant.FUND_BILL.getName());
		bill.setTotalCost(Double.parseDouble(req.getParameter("paySum")));
		bill.setTotalPrice(Double.parseDouble(req.getParameter("incomeSum")));
		bill.setDatetime(new Timestamp(DateUtil.getShortDateLong(req.getParameter("submitTime"))));
		bill.setStatus(Short.parseShort(req.getParameter("status"), 10));

		System.out.println("addTreatmentBill bill 插入数据库前: " + bill.getBillId());
		bill = bService.addBill(bill);
		System.out.println("addTreatmentBill bill 插入数据库后: " + bill.getBillId());

		// 插入billproject表
		JSONObject jo;
		BillProject bp;
		BillProjectId pk;
		List<BillProject> bpList = new ArrayList<BillProject>();
		for (int i = 0; i < projects.size(); i++) {
			jo = projects.getJSONObject(i);

			bp = new BillProject();
			pk = new BillProjectId(bill.getBillId(), jo.getLong("projectId"));

			bp.setId(pk);
			bp.setNumber((short) 0);
			bp.setPrice(jo.getDouble("price"));
			bp.setExtraInfo(jo.getString("markText"));

			bpList.add(bp);
		}

		System.out.println("addTreatmentBill bpList 插入前: " + JSON.toJSONString(bpList, false));
		bpList = bpService.addEntityList(bpList);
		System.out.println("addTreatmentBill bpList 插入后: " + JSON.toJSONString(bpList, false));

		return StringUtil.setResult(200, "添加成功", "");
	}
	
	
	
}

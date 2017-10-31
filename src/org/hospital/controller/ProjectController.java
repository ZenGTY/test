package org.hospital.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hospital.domain.Bill;
import org.hospital.domain.Employee;
import org.hospital.domain.Project;
import org.hospital.service.ProjectService;
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
@RequestMapping("projectController")
@SessionAttributes(value = "employee", types = Employee.class)
public class ProjectController {
	private static Logger log = LoggerFactory.getLogger(ProjectController.class);
	
	@Autowired
	private ProjectService pjService;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	@ResponseBody
	@RequestMapping(value = "/getAllFundProject", produces = "text/json;charset=utf-8")
	public String getAllFundProject(WebRequest req) {
		
		JSONArray resultJA = new JSONArray();
		List<Project> pjList = pjService.getFundProject();
		
		for (Iterator iterator = pjList.iterator(); iterator.hasNext();) {
			Project project = (Project) iterator.next();
			JSONObject pjJO = new JSONObject();
			pjJO.put("projectId", project.getProjectId());
			pjJO.put("projectName", project.getName());
			pjJO.put("creatorId", project.getEmployee().getEmployeeId());
			pjJO.put("creatorName", project.getEmployee().getName());
			pjJO.put("type", project.getType());
			pjJO.put("status", project.getStatus());
			pjJO.put("introduction", project.getIntroduction());
			Date date = new Date(project.getCreateTime().getTime());
			pjJO.put("createTime", sdf.format(date));
			resultJA.add(pjJO);
		}
		
		return StringUtil.setResult(200, "获取成功", JSON.toJSONString(resultJA));
	}
	
	@ResponseBody
	@RequestMapping(value = "/getAllTreatmentProject", produces = "text/json;charset=utf-8")
	public String getAllTreatmentProject(WebRequest req) {
		
		JSONArray resultJA = new JSONArray();
		List<Project> pjList = pjService.getTreatmentProject();
		
		for (Iterator iterator = pjList.iterator(); iterator.hasNext();) {
			Project project = (Project) iterator.next();
			JSONObject pjJO = new JSONObject();
			pjJO.put("projectId", project.getProjectId());
			pjJO.put("projectName", project.getName());
			pjJO.put("creatorId", project.getEmployee());
			pjJO.put("creatorName", project.getEmployee().getName());
			pjJO.put("unitPrice", project.getUnitPrice());
			pjJO.put("introduction", project.getIntroduction());
			pjJO.put("suggestNumber", project.getSuggestNumber());
			pjJO.put("type", project.getType());
			pjJO.put("status", project.getStatus());
			Date date = new Date(project.getCreateTime().getTime());
			pjJO.put("createTime", sdf.format(date));
			resultJA.add(pjJO);
		}
		
		return StringUtil.setResult(200, "获取成功", JSON.toJSONString(resultJA));
	}
}

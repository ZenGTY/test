package org.hospital.controller;

import com.alibaba.fastjson.JSONObject;

import org.hospital.domain.Employee;
import org.hospital.service.EmployeeService;
import org.hospital.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;

/**
 * Created by pismery on 2017-10-26.
 */
@Controller
@RequestMapping("loginController")
public class LoginController {

    @Autowired
    private EmployeeService employeeService;

    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.GET,produces = "text/json;charset=utf-8")
    public String login(WebRequest request,HttpSession session) {
        Employee e = employeeService.login(request.getParameter("account"), request.getParameter("pwd"));
        if(e == null) {
            return StringUtil.setResult(401,"账号密码错误","");
        }
        System.out.println("aaaaa");
        session.setAttribute("employee",e);
        return StringUtil.setResult(200,"登录成功", JSONObject.toJSONString(e));
    }
}

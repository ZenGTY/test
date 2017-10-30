package org.hospital.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hospital.domain.Employee;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class loginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object object)
			throws Exception {
		Employee employee = (Employee) req.getSession().getAttribute("employee");
		if (employee == null) {
			req.getRequestDispatcher("/login.html").forward(req, res);
			return false;
		}
		return true;
	}
}

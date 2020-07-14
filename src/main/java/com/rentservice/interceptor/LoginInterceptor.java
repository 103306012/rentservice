package com.rentservice.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import com.rentservice.service.UserService;

@Component
public class LoginInterceptor implements HandlerInterceptor {
	@Autowired
	private UserService userservice;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (!userservice.checklogin(request)) {
			String url = request.getServletPath();
			request.getSession().setAttribute("url_prior_login", url);
			response.sendRedirect("/login");
			return false;
		}
		return true;
	}

}

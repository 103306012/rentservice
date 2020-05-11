package com.roy.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.roy.user.service.UserService;

@Component
public class LoginInterceptor implements HandlerInterceptor {
	@Autowired
	private UserService userservice;

	/*
	 * @Override public boolean preHandle(HttpServletRequest request,
	 * HttpServletResponse response, Object handler) throws Exception { if
	 * (!userservice.checklogin(request)) { response.sendRedirect("/"); return
	 * false; } return true; }
	 */
	
}

package com.rentservice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.rentservice.model.LoginForm;
import com.rentservice.service.UserService;

@Controller
public class LogInOutController {
	@Autowired
	private UserService userservice;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String viewLogin(HttpServletRequest request, Model model) {
		if (userservice.checklogin(request)) {
			return "redirect:/";
		}
		String referrer = request.getHeader("Referer");
		if (referrer != null) {
			request.getSession().setAttribute("url_prior_login", referrer);
		}
		model.addAttribute("login", new LoginForm());
		return "Login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("login") @Valid LoginForm login, BindingResult bindingResult,
			HttpServletRequest request, Model model) {
		if (bindingResult.hasErrors() || !userservice.login(login, bindingResult)) {
			return "Login";
		}
		request.changeSessionId();
		HttpSession session = request.getSession(false);
		session.setAttribute("loginName", login.getUsername());
		session.setAttribute("loginId", userservice.getId(login.getUsername()));
		return "redirect:" + request.getSession().getAttribute("url_prior_login");
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		String referrer = request.getHeader("Referer");
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:" + referrer;
	}

}

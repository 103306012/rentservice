package com.roy.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.roy.user.model.Login;
import com.roy.user.model.User;
import com.roy.user.service.UserService;

@Controller
public class RegisterController {
	@Autowired
	private UserService userservice;

	@RequestMapping(value = { "/register" }, method = RequestMethod.GET)
	public String index(HttpServletRequest request, Model model) {
		String referrer = request.getHeader("Referer");
		request.getSession().setAttribute("url_prior_register", referrer);
		if (userservice.checklogin(request)) {
			return "redirect:" + request.getSession().getAttribute("url_prior_register");
		}
		model.addAttribute("user", new User());
		return "Register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
			HttpServletRequest request, Model model, RedirectAttributes redirAttr) {
		if (!userservice.register(user, bindingResult, request, model, redirAttr)) {
			return "Register";
		}
		return "redirect:" + request.getSession().getAttribute("url_prior_register");
	}

}

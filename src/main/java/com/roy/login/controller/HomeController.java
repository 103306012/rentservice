package com.roy.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.roy.login.model.User;

@Controller
public class HomeController {

	@RequestMapping(value = { "/index", "/login" }, method = RequestMethod.GET)
	public String index(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(true);
		if (session != null) {
			String loginuUsername = (String) session.getAttribute("login");
			if (loginuUsername != null) {
				model.addAttribute("username", loginuUsername);
				return "Home";
			}
		}
		model.addAttribute("user", new User());
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("User") @Valid User user, HttpServletRequest request,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {

			return "/index";
		} else if (!user.getUsername().equals("EX5399")) {
			bindingResult.rejectValue("username", "error.user", "username not correct");
			return "/index";
		} else {
			request.changeSessionId();
			HttpSession session = request.getSession(false);
			session.setAttribute("login", user.getUsername());
			model.addAttribute("username", user.getUsername());
		}
		return "redirect:/home";
	}

	@RequestMapping("/home")
	public String home(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		model.addAttribute("username", (String) session.getAttribute("login"));
		return "Home";
	}
}

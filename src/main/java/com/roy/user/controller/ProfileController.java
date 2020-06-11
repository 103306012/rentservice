package com.roy.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.roy.user.model.User;
import com.roy.user.service.UserService;

@Controller
@RequestMapping("/profile")
public class ProfileController {
	@Autowired
	private UserService userservice;

	@GetMapping
	public String getprofile(HttpServletRequest request, Model model) {
		String username = (String) request.getSession().getAttribute("login");
		User user = userservice.getprofile(username);
		model.addAttribute("user", user);
		return "Profile";
	}
}

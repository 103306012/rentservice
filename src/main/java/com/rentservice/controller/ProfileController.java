package com.rentservice.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.rentservice.model.User;
import com.rentservice.service.UserService;

@Controller
@RequestMapping("/profile")
public class ProfileController {
	@Autowired
	private UserService userservice;

	@GetMapping
	public String viewProfile(HttpSession session, Model model) {

		User user = userservice.getprofile((Integer) session.getAttribute("loginId"));
		model.addAttribute("user", user);
		return "Profile";
	}
}

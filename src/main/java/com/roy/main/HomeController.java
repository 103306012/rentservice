package com.roy.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.roy.main.login.model.User;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("user", new User());
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String submit(@ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
		if (!user.getUsername().equals("abc")) {
			bindingResult.reject("username", "username not correct");
			return "index";
		}
		model.addAttribute("username", user.getUsername());
		return "Home";
	}
}

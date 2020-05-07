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
import com.roy.user.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userservice;

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String Index(HttpServletRequest request, Model model) {
		if (userservice.checklogin(request)) {
			return "redirect:/home";
		}
		model.addAttribute("login", new Login());
		return "Index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("login") @Valid Login login, BindingResult bindingResult,
			HttpServletRequest request, Model model) {
		if (!userservice.findacoount(login, bindingResult, request, model)) {
			return "Index";
		}
		return "redirect:/home";
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, RedirectAttributes redirAttr) {
		userservice.logout(request, redirAttr);
		return "redirect:/";
	}

	@RequestMapping("/home")
	public String home(HttpServletRequest request, Model model) {
		return "Home";
	}
}

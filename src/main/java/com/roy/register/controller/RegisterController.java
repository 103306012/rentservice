package com.roy.register.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.roy.login.model.Login;
import com.roy.register.model.User;

@Controller
public class RegisterController {

	@RequestMapping(value = { "/register" }, method = RequestMethod.GET)
	public String index(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(true);
		if (session != null) {
			String loginuUsername = (String) session.getAttribute("login");
			if (loginuUsername != null) {
				return "redirect:/home";
			}
		}
		model.addAttribute("user", new User());
		return "Register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
			HttpServletRequest request, Model model, RedirectAttributes redirAttr) {
		if (bindingResult.hasErrors()) {
			return "Register";
		} else if (user.getUsername().equals("EX539901")) {
			bindingResult.rejectValue("username", "error.user", "帳號已使用");
			return "Register";
		}
		redirAttr.addFlashAttribute("message", "註冊成功");
		return "redirect:/";
	}

}

package com.roy.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.roy.login.model.Login;

@Controller
public class LoginController {

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String Index(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(true);
		if (session != null) {
			String loginuUsername = (String) session.getAttribute("login");
			if (loginuUsername != null) {
				return "Home";
			}
		}
		model.addAttribute("login", new Login());
		return "Index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("login") @Valid Login login, BindingResult bindingResult,
			HttpServletRequest request, Model model) {
		if (bindingResult.hasErrors()) {
			return "Index";
		} else if (!login.getUsername().equals("EX539901")) {
			bindingResult.rejectValue("username", "error.login", "username not correct");
			return "Index";
		} else {
			request.changeSessionId();
			HttpSession session = request.getSession(false);
			session.setAttribute("login", login.getUsername());
		}
		return "redirect:/home";
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, RedirectAttributes redirAttr) {
		HttpSession session = request.getSession();
		session.invalidate();
		redirAttr.addFlashAttribute("message", "成功登出");
		return "redirect:/";
	}

	@RequestMapping("/home")
	public String home(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		model.addAttribute("username", (String) session.getAttribute("login"));
		return "Home";
	}
}

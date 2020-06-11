package com.roy.user.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.roy.product.model.Product;
import com.roy.user.model.Login;
import com.roy.user.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userservice;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String Index(HttpServletRequest request, Model model) {
		if (userservice.checklogin(request)) {
			return "redirect:/";
		}
		String referrer = request.getHeader("Referer");
		request.getSession().setAttribute("url_prior_login", referrer);
		model.addAttribute("login", new Login());
		return "Login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("login") @Valid Login login, BindingResult bindingResult,
			HttpServletRequest request, Model model) {
		if (bindingResult.hasErrors() || !userservice.findacoount(login, bindingResult)) {
			return "Login";
		}
		request.changeSessionId();
		HttpSession session = request.getSession(false);
		session.setAttribute("login", login.getUsername());
		return "redirect:" + request.getSession().getAttribute("url_prior_login");
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, RedirectAttributes redirAttr) {

		return "redirect:" + userservice.logout(request, redirAttr);
	}

	@GetMapping(value = { "/home", "/" })
	public String home(HttpServletRequest request, Model model) {
		List<Product> list = new ArrayList();
		Product p1 = new Product();
		Product p2 = new Product();
		p1.setId(1);
		p2.setId(2);
		p1.setName("ps4");
		p2.setName("xboxs");
		List<String> filelist = new ArrayList();
		filelist.add("ps4-1.jpg");
		p1.setFiles(filelist);
		filelist = new ArrayList();
		filelist.add("xbox-1.jpg");
		p2.setFiles(filelist);
		list.add(p1);
		list.add(p2);
		model.addAttribute("productlist", list);
		model.addAttribute("noOfPages", 10);
		model.addAttribute("currentPage", "1");
		return "Home";
	}

	@GetMapping(value = "/home/{page}")
	public String home(@PathVariable(required = true) int page, Model model) {
		List<Product> list = new ArrayList();
		Product p1 = new Product();
		Product p2 = new Product();
		p1.setId(1);
		p2.setId(2);
		p1.setName("ps4");
		p2.setName("xboxs");
		List<String> filelist = new ArrayList();
		filelist.add("ps4-1.jpg");
		p1.setFiles(filelist);
		filelist = new ArrayList();
		filelist.add("xbox-1.jpg");
		p2.setFiles(filelist);
		list.add(p1);
		list.add(p2);
		model.addAttribute("productlist", list);
		model.addAttribute("noOfPages", 10);
		model.addAttribute("currentPage", page);
		return "Home";
	}

}

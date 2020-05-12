package com.roy.user.service;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.roy.user.model.Login;
import com.roy.user.model.User;

@Service
public class UserService {
	public boolean checklogin(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		if (session != null) {
			String loginuUsername = (String) session.getAttribute("login");
			if (loginuUsername != null) {
				return true;
			}
		}
		return false;
	}

	public boolean findacoount(Login login, Errors error, HttpServletRequest request, Model model) {
		if (error.hasErrors()) {
			return false;
		} else if (!login.getUsername().equals("nick850111")) {
			error.rejectValue("username", "error.login", "查無帳號");
			return false;
		} else if (!login.getPassword().equals("nick69888")) {
			error.rejectValue("password", "error.login", "密碼錯誤");
			return false;
		}
		request.changeSessionId();
		HttpSession session = request.getSession(false);
		session.setAttribute("login", login.getUsername());
		return true;
	}

	public void getprofile(Model model, String username) {
		User user = new User();
		user.setUsername(username);
		user.setName("Roy");
		user.setAddress("桃園市");
		user.setBirth(new Date());
		user.setEmail("roylove1258@gmail.com");
		model.addAttribute("user", user);
	}

	public String logout(HttpServletRequest request, RedirectAttributes redirAttr) {
		String referrer = request.getHeader("Referer");
		HttpSession session = request.getSession();
		session.invalidate();
		redirAttr.addFlashAttribute("message", "成功登出");
		return referrer;
	}

	public boolean register(User user, Errors error, HttpServletRequest request, Model model,
			RedirectAttributes redirAttr) {
		if (error.hasErrors())
			return false;
		else if (user.getUsername().equals("nick850111")) {
			error.rejectValue("username", "error.register", "帳號已註冊");
			return false;
		}
		redirAttr.addFlashAttribute("message", "註冊成功");
		return true;
	}
}

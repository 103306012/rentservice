package com.rentservice.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import com.rentservice.dao.UserMapper;
import com.rentservice.model.LoginForm;
import com.rentservice.model.User;

@Service
public class UserService {

	@Autowired
	private UserMapper mapper;

	public boolean checklogin(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		if (session != null) {
			String loginuUsername = (String) session.getAttribute("loginName");
			if (loginuUsername != null) {
				return true;
			}
		}
		return false;
	}

	public boolean login(LoginForm login, Errors error) {
		if (mapper.checkUsername(login.getUsername()) != 1) {
			error.rejectValue("username", "error.login", "查無帳號");
			return false;
		} else if (!mapper.findPassword(login.getUsername()).equals(login.getPassword())) {
			error.rejectValue("password", "error.login", "密碼錯誤");
			return false;
		}
		return true;
	}

	public User getprofile(String username) {
		User user = mapper.getUser(username);
		return user;
	}

	public int getId(String username) {
		return mapper.getId(username);
	}

	public boolean register(User user, Errors error) {
		if (mapper.checkUsername(user.getUsername()) == 1) {
			error.rejectValue("username", "error.register", "帳號已註冊");
			return false;
		}
		mapper.insertUser(user);
		return true;
	}
}

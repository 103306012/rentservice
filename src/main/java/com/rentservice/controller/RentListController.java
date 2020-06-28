package com.rentservice.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rentservice.dao.RentListMapper;
import com.rentservice.dao.UserMapper;
import com.rentservice.model.RentProfile;

@Controller
public class RentListController {
	@Autowired
	private UserMapper usermapper;
	@Autowired
	private RentListMapper rentlistmapper;

	@GetMapping("/rentlist")
	public String viewRentList(Model model, HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("login");
		int lender_id = usermapper.getId(username);
		List<RentProfile> list = rentlistmapper.selectLendProfile(lender_id);
		model.addAttribute("lend_list", list);

		list = rentlistmapper.selectBorrowProfile(lender_id);
		model.addAttribute("borrow_list", list);

		return "RentList";

	}
}

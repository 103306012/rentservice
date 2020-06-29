package com.rentservice.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rentservice.dao.ProductMapper;
import com.rentservice.dao.RentListMapper;
import com.rentservice.model.ProductWithImg;
import com.rentservice.service.UserService;

@Controller
@RequestMapping("/viewproduct")
public class ViewProductController {
	@Autowired
	private ProductMapper mapper;
	@Autowired
	private UserService userService;
	@Autowired
	private RentListMapper rentListMapper;

	@GetMapping("/{productid}")
	public String viewProduct(@PathVariable(required = true) int productid, Model model) {
		ProductWithImg productWithImg = mapper.selectProductWithImg(productid);
		model.addAttribute("productWithImg", productWithImg);
		return "ViewProduct";
	}

	@GetMapping("/rent/{productid}")
	public String rentProduct(@PathVariable(required = true) int productid, HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("login");
		int userId = userService.getId(username);
		rentListMapper.rentProduct(userId, productid);
		return "redirect:/rentlist";
	}
}

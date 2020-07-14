package com.rentservice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rentservice.service.ProductService;
import com.rentservice.service.RentListService;

@Controller
public class RentListController {
	@Autowired
	private RentListService rentListService;
	@Autowired
	private ProductService productService;

	@GetMapping("/rentlist")
	public String viewRentList(Model model, HttpSession session) {
		int userId = (Integer) session.getAttribute("loginId");
		model.addAttribute("lend_list", rentListService.selectLendList(userId));
		model.addAttribute("borrow_list", rentListService.selectBorrowList(userId));
		return "RentList";

	}

	@GetMapping("/rentlist/remove/{productId}")
	public String removeProduct(HttpServletRequest request, @PathVariable(required = true) int productId) {
		productService.removeProduct(productId);
		return "redirect:/rentlist";

	}

	@GetMapping("/rentlist/updatefinish/{productId}")
	public String finishRentList(HttpServletRequest request, @PathVariable(required = true) int productId) {
		rentListService.finishRentList(productId);
		return "redirect:/rentlist";

	}

	@GetMapping("/rentlist/updatecancel/{productId}")
	public String cancelRentList(HttpServletRequest request, @PathVariable(required = true) int productId) {
		rentListService.cancelRentList(productId);
		return "redirect:/rentlist";

	}
}

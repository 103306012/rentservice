package com.rentservice.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.rentservice.model.ProductWithImg;
import com.rentservice.service.ProductService;

@Controller
@RequestMapping("/viewproduct")
public class ViewProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/{productId}")
	public String viewProduct(@PathVariable(required = true) int productId, Model model) {
		ProductWithImg productWithImg = productService.ViewProduct(productId);
		model.addAttribute("productWithImg", productWithImg);
		return "ViewProduct";
	}

	@GetMapping("/rent/{productId}")
	public String rentProduct(@PathVariable(required = true) int productId, HttpServletRequest request) {
		productService.RentProduct((int) request.getSession().getAttribute("loginId"), productId);
		return "redirect:/rentlist";
	}
}

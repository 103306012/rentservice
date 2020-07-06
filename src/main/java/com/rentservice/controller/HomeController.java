package com.rentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.rentservice.service.ProductService;

@Controller
public class HomeController {

	@Autowired
	private ProductService productService;

	@GetMapping(value = { "/home", "/", "/home/{page}" })
	public String viewHome(@PathVariable(required = false) Integer page, Model model) {

		page = page == null ? 0 : page - 1;
		model.addAttribute("productlist", productService.ViewProductList(null, null, page));
		model.addAttribute("noOfPages", productService.GetProductListCount(null, null));
		model.addAttribute("currentPage", page + 1);
		return "Home";

	}
}
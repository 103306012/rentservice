package com.rentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.rentservice.service.ProductService;

@Controller
@RequestMapping("/category")
public class ViewCategoryController {
	@Autowired
	private ProductService productService;

	@GetMapping(value = { "/{category}", "/{category}/{page}" })
	public String gettype(@PathVariable(required = true) String category, @PathVariable(required = false) Integer page,
			Model model) {
		page = page == null ? 0 : page - 1;
		model.addAttribute("productlist", productService.ViewProductList("type", category, page));
		model.addAttribute("noOfPages", productService.GetProductListCount("type", category));
		model.addAttribute("currentPage", page + 1);
		return "Home";

	}
}

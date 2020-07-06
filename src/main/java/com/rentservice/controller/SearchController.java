package com.rentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.rentservice.service.ProductService;

@Controller
@RequestMapping("/search")
public class SearchController {

	@Autowired
	private ProductService productService;

	@GetMapping(value = { "/{productName}", "/{productName}/{page}" })
	public String search(@PathVariable(required = true) String productName,
			@PathVariable(required = false) Integer page, Model model) {
		page = page == null ? 0 : page - 1;
		model.addAttribute("productlist", productService.ViewProductList("name", productName, page));
		model.addAttribute("noOfPages", productService.GetProductListCount("name", productName));
		model.addAttribute("currentPage", page + 1);
		return "Home";
	}
}

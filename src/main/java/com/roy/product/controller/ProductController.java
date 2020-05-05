package com.roy.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.roy.product.model.Product;

@Controller
public class ProductController {

	@GetMapping("/addproduct")
	public String addProductinitial(Model model) {
		Product p =new Product();
		p.setDetail(" ");
		model.addAttribute("product",p);
		return "Product";
	}

}


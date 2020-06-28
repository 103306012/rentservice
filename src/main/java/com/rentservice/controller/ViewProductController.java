package com.rentservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rentservice.model.Product;

@Controller
@RequestMapping("/viewproduct")
public class ViewProductController {
	@GetMapping("/{productid}")
	public String viewProduct(@PathVariable(required = true) int productid, Model model) {
		Product p = new Product();
		if (productid == 1) {
			p.setProduct_id(productid);
			p.setName("PS4");
			p.setType("電動");
			p.setPrice("100");
			p.setDetail("最新PS4");
			List<String> list = new ArrayList<String>();
			list.add("ps4-1.jpg");
			list.add("ps4-2.jpg");
			p.setFiles(list);
		} else {
			p.setProduct_id(productid);
			p.setName("XBOX");
			p.setType("電動");
			p.setPrice("100");
			p.setDetail("最新XBOXS");
			List<String> list = new ArrayList<String>();
			list.add("xbox-1.jpg");
			list.add("xbox-2.jpg");
			p.setFiles(list);
		}
		model.addAttribute("product", p);
		return "ViewProduct";
	}
}

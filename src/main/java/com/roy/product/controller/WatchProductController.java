package com.roy.product.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.roy.product.model.Product;

@Controller
@RequestMapping("/watchproduct")
public class WatchProductController {
	@GetMapping("/{productid}")
	public String watchproduct(@PathVariable(required = true) int productid, Model model) {
		Product p = new Product();
		if (productid == 1) {
			p.setId(productid);
			p.setName("PS4");
			p.setType("電動");
			p.setPrice("100");
			p.setDetail("最新PS4");
			List<String> list = new ArrayList();
			list.add("ps4-1.jpg");
			list.add("ps4-2.jpg");
			p.setFiles(list);
		} else {
			p.setId(productid);
			p.setName("XBOX");
			p.setType("電動");
			p.setPrice("100");
			p.setDetail("最新XBOXS");
			List<String> list = new ArrayList();
			list.add("xbox-1.jpg");
			list.add("xbox-2.jpg");
			p.setFiles(list);
		}
		model.addAttribute("product", p);
		return "WatchProduct";
	}
}

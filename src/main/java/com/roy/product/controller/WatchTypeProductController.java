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
@RequestMapping("/type")
public class WatchTypeProductController {
	@GetMapping("/{typename}")
	public String gettype(@PathVariable(required = true) String typename, Model model) {
		if (typename.equals("videogame")) {
			List<Product> list = new ArrayList();
			Product p1 = new Product();
			Product p2 = new Product();
			p1.setId(1);
			p2.setId(2);
			p1.setName("ps4");
			p2.setName("xboxs");
			List<String> filelist = new ArrayList();
			filelist.add("ps4-1.jpg");
			p1.setFiles(filelist);
			filelist = new ArrayList();
			filelist.add("xbox-1.jpg");
			p2.setFiles(filelist);
			list.add(p1);
			list.add(p2);
			model.addAttribute("productlist", list);
		}
		return "Home";
	}
}

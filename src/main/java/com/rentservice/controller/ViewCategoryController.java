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
@RequestMapping("/category")
public class ViewCategoryController {
	@GetMapping("/{category}")
	public String gettype(@PathVariable(required = true) String category, Model model) {
		if (category.equals("videogame")) {
			List<Product> list = new ArrayList<Product>();
			Product p1 = new Product();
			Product p2 = new Product();
			Product p3 = new Product();
			Product p4 = new Product();
			p1.setProduct_id(1);
			p2.setProduct_id(2);
			p3.setProduct_id(3);
			p4.setProduct_id(4);
			p1.setName("ps4");
			p2.setName("xboxs");
			p3.setName("switch");
			p4.setName("ps5");
			List<String> filelist = new ArrayList<String>();
			filelist.add("ps4-1.jpg");
			p1.setFiles(filelist);
			filelist = new ArrayList<String>();
			filelist.add("xbox-1.jpg");
			p2.setFiles(filelist);
			filelist = new ArrayList<String>();
			filelist.add("switch-1.jpg");
			p3.setFiles(filelist);
			filelist = new ArrayList<String>();
			filelist.add("ps5-1.jpg");
			p4.setFiles(filelist);
			list.add(p1);
			list.add(p2);
			list.add(p3);
			list.add(p4);
			model.addAttribute("productlist", list);
		}
		return "Home";
	}
}

package com.rentservice.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.rentservice.model.Product;

@Controller
public class HomeController {

	@GetMapping(value = { "/home", "/", "/home/{page}" })
	public String viewHome(@PathVariable(required = false) Integer page, Model model) {
		if (page == null) {
			List<Product> list = new ArrayList<Product>();
			Product p1 = new Product();
			Product p2 = new Product();
			p1.setProduct_id(1);
			p2.setProduct_id(2);
			p1.setName("ps4");
			p2.setName("xboxs");
			List<String> filelist = new ArrayList<String>();
			filelist.add("ps4-1.jpg");
			p1.setFiles(filelist);
			filelist = new ArrayList<String>();
			filelist.add("xbox-1.jpg");
			p2.setFiles(filelist);
			list.add(p1);
			list.add(p2);
			model.addAttribute("productlist", list);
			model.addAttribute("noOfPages", 10);
			model.addAttribute("currentPage", "1");
			return "Home";
		} else {
			List<Product> list = new ArrayList<Product>();
			Product p1 = new Product();
			Product p2 = new Product();
			p1.setProduct_id(1);
			p2.setProduct_id(2);
			p1.setName("ps4");
			p2.setName("xboxs");
			List<String> filelist = new ArrayList<String>();
			filelist.add("ps4-1.jpg");
			p1.setFiles(filelist);
			filelist = new ArrayList<String>();
			filelist.add("xbox-1.jpg");
			p2.setFiles(filelist);
			list.add(p1);
			list.add(p2);
			model.addAttribute("productlist", list);
			model.addAttribute("noOfPages", 10);
			model.addAttribute("currentPage", page);
			return "Home";
		}

	}

}

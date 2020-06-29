package com.rentservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rentservice.dao.ProductMapper;
import com.rentservice.model.ProductWithImg;

@Controller
@RequestMapping("/search")
public class SearchController {
	@Autowired
	private ProductMapper mapper;

	@GetMapping(value = { "/{productName}", "/{productName}/{page}" })
	public String search(@PathVariable(required = true) String productName,
			@PathVariable(required = false) Integer page, Model model) {
		if (page == null) {
			page = 1;
		}
		page = page - 1;
		List<ProductWithImg> list = mapper.selectAllProductWithImg("name", productName, page * 9, page * 9 + 9);
		model.addAttribute("productlist", list);
		model.addAttribute("noOfPages", mapper.selectProductCount("name", productName) / 10 + 1);
		model.addAttribute("currentPage", page+1);
		return "Home";
	}
}

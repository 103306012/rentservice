package com.roy.product.controller;

import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.roy.product.model.UploadProduct;

@Controller
@RequestMapping("/uploadproduct")
public class UploadProductController {

	@GetMapping
	public String initialview(Model model) {
		UploadProduct p = new UploadProduct();
		p.setDetail(" ");
		model.addAttribute("product", p);
		return "Product";
	}

	@PostMapping
	public String uploadproduct(HttpServletRequest servletRequest, @ModelAttribute UploadProduct uploadproduct,
			Model model) {
		List<MultipartFile> files = uploadproduct.getFiles();
		List<String> fileNames = new ArrayList<String>();
		if (null != files && files.size() > 0) {
			for (MultipartFile multipartFile : files) {

				String fileName = multipartFile.getOriginalFilename();
				fileNames.add(fileName);

				File imageFile = new File(servletRequest.getServletContext().getRealPath("/image"), fileName);
				try {
					multipartFile.transferTo(imageFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "Home";
	}

}

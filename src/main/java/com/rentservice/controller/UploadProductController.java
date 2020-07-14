package com.rentservice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.rentservice.model.UploadProductForm;
import com.rentservice.service.UploadService;

@Controller
@RequestMapping("/uploadproduct")
public class UploadProductController {
	@Autowired
	UploadService uploadService;

	@GetMapping
	public String viewUpload(Model model) {
		UploadProductForm upload = new UploadProductForm();
		upload.setDetail("商品內容");
		model.addAttribute("upload", upload);
		return "UploadProduct";
	}

	@PostMapping
	public String uploadproduct(HttpServletRequest servletRequest,
			@ModelAttribute("upload") @Valid UploadProductForm upload, BindingResult bindingResult,
			HttpSession session) {
		if (!uploadService.upload(upload, bindingResult,session)) {
			return "UploadProduct";
		}
		return "redirect:/";
	}

}

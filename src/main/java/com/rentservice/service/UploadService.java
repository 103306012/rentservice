package com.rentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import com.rentservice.model.Product;
import com.rentservice.model.RentList;
import com.rentservice.model.Status;
import com.rentservice.model.UploadProductForm;

@Service
public class UploadService {
	@Autowired
	ProductService productService;
	@Autowired
	ImgService imgService;
	@Autowired
	RentListService rentListService;
	@Autowired
	UserService userService;

	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean upload(UploadProductForm upload, BindingResult bindingResult, String path, String username) {
		if (upload.getType().equals("null")) {
			bindingResult.rejectValue("type", "error.upload", "請選擇類型");
			return false;
		}
		if (!upload.getPrice().chars().allMatch(Character::isDigit)) {
			bindingResult.rejectValue("price", "error.upload", "價錢請輸入數字");
			return false;
		}
		if (upload.getFiles().get(0).isEmpty()) {
			bindingResult.rejectValue("files", "error.upload", "未上傳圖片");
			return false;
		}
		imgService.uploadImg(upload, path);
		Product product = new Product(upload);
		productService.insertProduct(product);
		imgService.insertImg(product);
		RentList rentList = new RentList();
		rentList.setProduct_id(product.getProduct_id());
		rentList.setLender_id(userService.getId(username));
		rentList.setStatus(Status.WATING);
		rentListService.inserRentList(rentList);
		return true;
	}
}

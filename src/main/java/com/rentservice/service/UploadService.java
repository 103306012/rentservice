package com.rentservice.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;
import com.rentservice.model.Product;
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

	@Value("${directory.path}")
	private String path;

	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean upload(UploadProductForm upload, BindingResult bindingResult, HttpSession session) {
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
		uploadImg(upload, path);
		Product product = new Product(upload);
		productService.insertProduct(product);
		imgService.insertImg(product);
		int userId = (Integer) session.getAttribute("loginId");
		rentListService.inserRentList(product, userId);
		return true;
	}

	public void uploadImg(UploadProductForm uploadProductForm, String path) {
		List<MultipartFile> files = uploadProductForm.getFiles();
		List<String> fileNames = new ArrayList<String>();
		if (null != files && files.size() > 0) {
			for (MultipartFile multipartFile : files) {

				String fileName = multipartFile.getOriginalFilename();
				fileNames.add(fileName);

				File imageFile = new File(path, fileName);
				try {
					multipartFile.transferTo(imageFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}
}

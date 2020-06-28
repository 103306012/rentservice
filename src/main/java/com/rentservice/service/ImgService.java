package com.rentservice.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rentservice.dao.ImgMapper;
import com.rentservice.model.Product;
import com.rentservice.model.UploadProductForm;

@Service
public class ImgService {
	@Autowired
	private ImgMapper mapper;

	public int insertImg(Product product) {
		return mapper.insertImgList(product);
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

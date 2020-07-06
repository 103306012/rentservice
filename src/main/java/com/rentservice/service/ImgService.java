package com.rentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rentservice.dao.ImgMapper;
import com.rentservice.model.Product;

@Service
public class ImgService {
	@Autowired
	private ImgMapper mapper;

	public int insertImg(Product product) {
		return mapper.insertImgList(product);
	}

}

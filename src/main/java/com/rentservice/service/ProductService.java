package com.rentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentservice.dao.ImgMapper;
import com.rentservice.dao.ProductMapper;
import com.rentservice.dao.RentListMapper;
import com.rentservice.model.Product;

@Service
public class ProductService {
	@Autowired
	private ProductMapper mapper;
	@Autowired
	private RentListMapper rentListMapper;
	@Autowired
	private ImgMapper imgMapper;

	public void insertProduct(Product product) {
		mapper.insertProduct(product);
	}

	public void removeProduct(int productId) {
		rentListMapper.removeRentList(productId);
		imgMapper.deleteImg(productId);
		mapper.removeProduct(productId);
	}
}

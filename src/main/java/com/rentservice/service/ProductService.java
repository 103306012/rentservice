package com.rentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rentservice.dao.ProductMapper;
import com.rentservice.model.Product;

@Service
public class ProductService {
	@Autowired
	private ProductMapper mapper;

	public void insertProduct(Product product) {
		mapper.insertProduct(product);
	}

}

package com.rentservice.dao;

import org.apache.ibatis.annotations.Mapper;

import com.rentservice.model.Product;

@Mapper
public interface ProductMapper {
	int insertProduct(Product product);

	Product selectProduct(String product_id);
}

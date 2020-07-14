package com.rentservice.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.rentservice.dao.ImgMapper;
import com.rentservice.dao.ProductMapper;
import com.rentservice.dao.RentListMapper;
import com.rentservice.model.Product;
import com.rentservice.model.ProductWithImg;

@Service
public class ProductService {
	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private RentListMapper rentListMapper;
	@Autowired
	private ImgMapper imgMapper;

	public void insertProduct(Product product) {
		productMapper.insertProduct(product);
	}

	public void removeProduct(int productId) {
		rentListMapper.removeRentList(productId);
		imgMapper.deleteImg(productId);
		productMapper.removeProduct(productId);
	}

	@Cacheable(value = "product", key = "#productId")
	public ProductWithImg ViewProduct(int productId) {
		return productMapper.selectProductWithImg(productId);
	}

	public void RentProduct(int productId, HttpSession session) {
		int userId = (Integer) session.getAttribute("loginId");
		rentListMapper.rentProduct(userId, productId);
	}

	public List<ProductWithImg> ViewProductList(String column, String condition, int page) {
		return productMapper.selectAllProductWithImg(column, condition, page * 9, page * 9 + 9);
	}

	public int GetProductListCount(String column, String condition) {
		return productMapper.selectProductCount(column, condition) / 10 + 1;
	}

}

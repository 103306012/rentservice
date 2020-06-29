package com.rentservice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.rentservice.model.Product;
import com.rentservice.model.ProductWithImg;

@Mapper
public interface ProductMapper {
	public int insertProduct(Product product);

	public Product selectProduct(String productId);

	public void removeProduct(int productId);

	public List<ProductWithImg> selectAllProductWithImg(@Param("column") String column,
			@Param("condition") String condition, @Param("from") int from, @Param("to") int to);

	public ProductWithImg selectProductWithImg(int productId);

	public int selectProductCount(@Param("column") String column, @Param("condition") String condition);

}

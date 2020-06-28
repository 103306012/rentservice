package com.rentservice.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.rentservice.model.Product;

@Mapper
public interface ImgMapper {
	int insertImgList(@Param("product") Product product);
}

package com.rentservice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.rentservice.model.Img;
import com.rentservice.model.Product;

@Mapper
public interface ImgMapper {
	int insertImgList(@Param("product") Product product);

	void deleteImg(int productId);

	List<Img> selectImgs(int productId);
}

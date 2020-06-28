package com.rentservice.dao;

import org.apache.ibatis.annotations.Mapper;

import com.rentservice.model.User;

@Mapper
public interface UserMapper {

	int insertUser(User user);

	int checkUsername(String username);

	String findPassword(String username);

	User getUser(String username);

	int getId(String username);

}

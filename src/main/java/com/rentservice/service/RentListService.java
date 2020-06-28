package com.rentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentservice.dao.RentListMapper;
import com.rentservice.model.RentList;

@Service
public class RentListService {
	@Autowired
	private RentListMapper mapper;

	public void inserRentList(RentList rentList) {
		mapper.inserRentList(rentList);
	}
}

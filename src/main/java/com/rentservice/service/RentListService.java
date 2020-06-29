package com.rentservice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rentservice.dao.RentListMapper;
import com.rentservice.model.RentList;
import com.rentservice.model.RentProfile;
import com.rentservice.model.Status;

@Service
public class RentListService {
	@Autowired
	private RentListMapper mapper;

	public void inserRentList(RentList rentList) {
		mapper.inserRentList(rentList);
	}

	public List<RentProfile> selectLendList(int userId) {
		return mapper.selectLendProfile(userId);
	}

	public List<RentProfile> selectBorrowList(int userId) {
		return mapper.selectBorrowProfile(userId);
	}

	public void finishRentList(int productId) {
		mapper.updateStatus(Status.FINISHED.ordinal(), productId);
	}

	public void cancelRentList(int productId) {
		mapper.updateStatus(Status.WATING.ordinal(), productId);
	}
}

package com.rentservice.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.rentservice.model.RentList;
import com.rentservice.model.RentProfile;

@Mapper
public interface RentListMapper {
	public void inserRentList(RentList rentList);

	public List<RentProfile> selectLendProfile(int lender_id);

	public List<RentProfile> selectBorrowProfile(int borrower_id);

	public void removeRentList(int productId);

	public void updateStatus(@Param("status") int status, @Param("productId") int productId);

	public void rentProduct(@Param("userId") int userId, @Param("productId") int productId);
}

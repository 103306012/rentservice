package com.rentservice.model;

public class RentList {
	private int id;
	private int product_id;
	private int lender_id;
	private int borrow_id;
	private Status status;

	public RentList(int id, int product_id, int lender_id, int borrow_id, Status status) {
		super();
		this.id = id;
		this.product_id = product_id;
		this.lender_id = lender_id;
		this.borrow_id = borrow_id;
		this.status = status;
	}

	public RentList() {
		super();
	}

	public int getId() {
		return id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public int getLender_id() {
		return lender_id;
	}

	public int getBorrow_id() {
		return borrow_id;
	}

	public Status getStatus() {
		return status;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public void setLender_id(int lender_id) {
		this.lender_id = lender_id;
	}

	public void setBorrow_id(int borrow_id) {
		this.borrow_id = borrow_id;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}

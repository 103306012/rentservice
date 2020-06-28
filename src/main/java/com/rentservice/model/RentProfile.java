package com.rentservice.model;

public class RentProfile {
	private String product_name;
	private String type;
	private int price;
	private String address;
	private String detail;
	private String name;
	private Status status;

	public RentProfile() {
		super();
	}

	public RentProfile(String product_name, String type, int price, String address, String detail, String name,
			Status status) {
		super();
		this.product_name = product_name;
		this.type = type;
		this.price = price;
		this.address = address;
		this.detail = detail;
		this.name = name;
		this.status = status;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}

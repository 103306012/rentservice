package com.rentservice.model;

public class RentProfile {
	private int productId;
	private String productName;
	private String type;
	private int price;
	private String address;
	private String detail;
	private String name;
	private Status status;

	public RentProfile() {
		super();
	}

	public RentProfile(int productId, String productName, String type, int price, String address, String detail,
			String name, Status status) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.type = type;
		this.price = price;
		this.address = address;
		this.detail = detail;
		this.name = name;
		this.status = status;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

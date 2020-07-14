package com.rentservice.model;

import java.io.Serializable;
import java.util.List;

public class ProductWithImg implements Serializable {

	private static final long serialVersionUID = 1L;
	private int productId;
	private String name;
	private String type;
	private int price;
	private String address;
	private String detail;
	private List<Img> imgList;

	public ProductWithImg() {
		super();
	}

	public ProductWithImg(int productId, String name, String type, int price, String address, String detail,
			List<Img> imgList) {
		super();
		this.productId = productId;
		this.name = name;
		this.type = type;
		this.price = price;
		this.address = address;
		this.detail = detail;
		this.imgList = imgList;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<Img> getImgList() {
		return imgList;
	}

	public void setImgList(List<Img> imgList) {
		this.imgList = imgList;
	}

}

package com.rentservice.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Product {
	private int product_id;
	private String name;
	private String type;
	private String price;
	private String address;
	private String detail;
	private List<String> files;

	public Product() {
		super();
	}

	public Product(int product_id, String name, String type, String price, String address, String detail,
			List<String> files) {
		super();
		this.product_id = product_id;
		this.name = name;
		this.type = type;
		this.price = price;
		this.address = address;
		this.detail = detail;
		this.files = files;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
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

	public List<String> getFiles() {
		return files;
	}

	public void setFiles(List<String> files) {
		this.files = files;
	}

	public Product(UploadProductForm uploadProductForm) {
		this.name = uploadProductForm.getName();
		this.type = uploadProductForm.getType();
		this.price = uploadProductForm.getPrice();
		this.address = uploadProductForm.getAddress();
		this.detail = uploadProductForm.getDetail();
		List<String> files = new ArrayList<String>();
		for (MultipartFile multipartFile : uploadProductForm.getFiles()) {
			files.add(multipartFile.getOriginalFilename());
		}
		this.files = files;

	}
}

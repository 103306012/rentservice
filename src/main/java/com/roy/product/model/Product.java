package com.roy.product.model;

import java.util.List;

public class Product {
	private int id;
	private String name;
	private String type;
	private String price;
	private String detail;
	private List<String> files;

	public Product() {
		super();
	}

	public Product(int id, String name, String type, String price, String detail, List<String> files) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
		this.detail = detail;
		this.files = files;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

}

package com.roy.product.model;

import org.springframework.web.multipart.MultipartFile;

public class Product {
	private String name;
	private String type;
	private String detail;
	private MultipartFile[] files;

	public Product(String name, String type, String detail, MultipartFile[] files) {
		super();
		this.name = name;
		this.type = type;
		this.detail = detail;
		this.files = files;
	}

	public Product() {
		super();
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

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public MultipartFile[] getFiles() {
		return files;
	}

	public void setFiles(MultipartFile[] files) {
		this.files = files;
	}

}

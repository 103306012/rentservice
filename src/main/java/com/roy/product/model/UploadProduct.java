package com.roy.product.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class UploadProduct implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String type;
	private String price;
	private String detail;
	private List<MultipartFile> files;

	public UploadProduct(String name, String type, String price, String detail, List<MultipartFile> files) {
		super();
		this.name = name;
		this.type = type;
		this.price = price;
		this.detail = detail;
		this.files = files;
	}

	public UploadProduct() {
		// TODO Auto-generated constructor stub
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

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

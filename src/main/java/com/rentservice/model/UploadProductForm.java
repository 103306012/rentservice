package com.rentservice.model;

import java.util.List;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.web.multipart.MultipartFile;

public class UploadProductForm {
	private String name;
	private String type;
	@NumberFormat
	private String price;
	private String detail;
	private String address;
	private List<MultipartFile> files;

	public UploadProductForm(String name, String type, String price, String detail, String address,
			List<MultipartFile> files) {
		super();
		this.name = name;
		this.type = type;
		this.price = price;
		this.detail = detail;
		this.address = address;
		this.files = files;
	}

	public UploadProductForm() {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

}

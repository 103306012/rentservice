package com.rentservice.model;

import java.io.Serializable;

public class Img implements Serializable {
	private static final long serialVersionUID = 1L;
	private int imgId;
	private int productId;
	private String url;

	public Img() {
		super();
	}

	public Img(int imgId, int productId, String url) {
		super();
		this.imgId = imgId;
		this.productId = productId;
		this.url = url;
	}

	public int getImgId() {
		return imgId;
	}

	public void setImgId(int imgId) {
		this.imgId = imgId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}

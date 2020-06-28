package com.rentservice.model;

public enum Status {
	WATING("尚未租借"), GOING("租借中"), FINISHED("完成");

	private String name;

	private Status(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

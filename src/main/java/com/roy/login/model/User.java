package com.roy.login.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User {
	@NotEmpty(message = "validation.username.Empty")
	@Size(min = 8, max = 12, message = "validation.username.Length")
	private String username;
	@NotEmpty(message = "validation.password.Empty")
	@Size(min = 8, max = 12, message = "{validation.password.Length}")
	private String password;

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public User() {
		super();
	}

}

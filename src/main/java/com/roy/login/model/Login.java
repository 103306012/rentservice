package com.roy.login.model;


import javax.validation.constraints.Size;

public class Login {
	@Size(min = 8, max = 12)
	private String username;
	@Size(min = 8, max = 12)
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

	public Login(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Login() {
		super();
	}

}

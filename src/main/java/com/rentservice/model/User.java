package com.rentservice.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
	private int id;
	@Size(min = 8, max = 12)
	private String username;
	@Size(min = 8, max = 12)
	private String password;
	@NotEmpty
	private String name;
	@NotEmpty
	private String email;
	@NotEmpty
	private String address;
	@NotNull
	private String birth;

	public User(int id, @Size(min = 8, max = 12) String username, @Size(min = 8, max = 12) String password,
			@NotEmpty String name, @NotEmpty String email, @NotEmpty String address, @NotNull String birth) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.address = address;
		this.birth = birth;
	}

	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

}

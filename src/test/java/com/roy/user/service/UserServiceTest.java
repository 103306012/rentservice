package com.roy.user.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.validation.Errors;

import com.roy.user.model.Login;

public class UserServiceTest {
	private static UserService userservice;

	@BeforeAll
	public static void setup() {
		userservice = new UserService();
	}

	@Test
	void findacoountTest() {
		Login login = new Login();
		login.setUsername("nick850111");
		login.setPassword("nick69888");
		assertThat(userservice.findacoount(login, mock(Errors.class))).isTrue();
	}
}

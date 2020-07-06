package com.rentservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import com.rentservice.dao.UserMapper;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class RentServiceTest {
	@Autowired
	private UserMapper UserMapper;

	@Test
	void test() {
		int i = UserMapper.checkUsername("nick850111");
		Assertions.assertEquals(1, i);
		System.out.println(i);
	}

}

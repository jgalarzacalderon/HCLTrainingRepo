package com.example.UserManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.UserManager.entities.User;
import com.example.UserManager.services.UserService;

@SpringBootTest
class UserManagerApplicationTests {
	
	@Autowired
	UserService userService;
	
	@Test
	void contextLoads() {
	}

	/*
	 * @Test void loadTestData() {
	 * 
	 * User testUser = new User(); testUser.setName("Tim");
	 * testUser.setPassword("password");
	 * testUser.setEmail("someemailtest@someemail.com");
	 * 
	 * userService.updateUser(testUser); }
	 */
}

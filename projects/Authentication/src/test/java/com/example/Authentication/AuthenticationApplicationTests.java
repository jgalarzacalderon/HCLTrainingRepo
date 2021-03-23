package com.example.Authentication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.example.Authentication.entities.User;
import com.example.Authentication.services.UserService;
import com.example.Authentication.repositories.UserRepository;


@SpringBootTest
@Transactional
class AuthenticationApplicationTests {

	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	void contextLoads() {
	}

	@Test
	@Rollback(true)
	void testServiceCall() {
		Iterable<User> users = userService.getAllUsers();
		
		Integer count = 0;
		for (User u: users) {
			count ++;
		}
		
		assertNotEquals(count, 0);
	}
	
	@Test
	@Rollback(true)
	void testGetUserByName() {
		
		//Put user object in repository
		User savedUser = new User();
    	savedUser.setName("name");
    	savedUser.setEmail("email");
    	savedUser.setPassword("password");
    	userRepository.save(savedUser);
    	
    	// Get the user into User Object
    	User user = userService.getUserByName("name");
    	
    	// Should return with the name "name"
    	assertEquals(user.getName(), "name");
	}
	
	@Test
	@Rollback(true)
	void testValidateUser_WhenSuccess() {
		
		//Put user object in repository
		User savedUser = new User();
    	savedUser.setName("name");
    	savedUser.setEmail("email");
    	savedUser.setPassword("password");
    	userRepository.save(savedUser);
    	
    	// Name and password variable to test against
    	String name = "name";
    	String password = "password";
    	
    	// Pass variables to validate user exist should return "success"
    	String result =userService.validateUser(name, password);
    	
    	// Test that result received "success" as it's string
    	assertEquals(result, "success");
	}
	
	@Test
	@Rollback(true)
	void testValidateUser_WhenError() {
		
		//Put user object in repository
		User savedUser = new User();
    	savedUser.setName("name");
    	savedUser.setEmail("email");
    	savedUser.setPassword("password");
    	userRepository.save(savedUser);
    	
    	// Name and password variable to test against
    	String name = "name";
    	String password = "wrongpass";
    	
    	// Pass variables to validate user exist should return "success"
    	String result =userService.validateUser(name, password);
    	
    	// Test that result received "success" as it's string
    	assertEquals(result, "error");
	}

}
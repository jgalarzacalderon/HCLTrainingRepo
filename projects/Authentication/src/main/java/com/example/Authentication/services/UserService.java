
package com.example.Authentication.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Authentication.entities.User;
import com.example.Authentication.exceptions.UserNotFoundException;
import com.example.Authentication.repositories.UserRepository;



@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
    public Iterable<User> getAllUsers()
    {
        return userRepository.findAll();
    }


    public User getUserByName(String name) {
        User foundUser = userRepository.findByName(name);
        return foundUser;
    }
    
    public String validateUser(String name, String password) {
    	
    	String validation;
    	User user = getUserByName(name);
    	
    	if (user.getName().equals(name) && user.getPassword().equals(password)) {
    		validation = "success";
    	} else {
    		validation = "error";
    	}
    	
    	return validation;
    }


}
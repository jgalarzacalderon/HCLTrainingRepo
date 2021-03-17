package com.example.UserManager.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UserManager.controllers.UserController;
import com.example.UserManager.entities.User;
import com.example.UserManager.exceptions.UserNotFoundException;
import com.example.UserManager.repositories.UserRepository;


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

    public User getUserById(int id) {
    	Optional<User> foundUser = userRepository.findById(id);
    	
    	if(foundUser.isPresent()) {
        	return(foundUser.get());
    	} else {
    		throw new UserNotFoundException();
    	}
    	
    }
    
    public void updateUser(User update) {
    	
    	try {
			userRepository.save(update);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
    		throw new UserNotFoundException();

		}
    }

}
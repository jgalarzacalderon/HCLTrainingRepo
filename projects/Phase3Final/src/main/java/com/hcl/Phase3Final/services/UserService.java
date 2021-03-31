package com.hcl.Phase3Final.services;

import java.util.Arrays;
import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hcl.Phase3Final.model.Role;
import com.hcl.Phase3Final.model.User;
import com.hcl.Phase3Final.repositories.RoleRepository;
import com.hcl.Phase3Final.repositories.TaskRepository;
import com.hcl.Phase3Final.repositories.UserRepository;

@Service
public class UserService {
    
	//HAS A relationship
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findUserByUserName(String userName) {
		logger.info("Printing userName passed from controller: " + userName);

    	if (userRepository.findByUserName(userName) != null) {
			logger.info("Printing the content of the User object from findByUserName()"
					+ userRepository.findByUserName(userName).toString());
		}
    	User foundUser = userRepository.findByUserName(userName);
		return foundUser;
    }

    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(true);
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return userRepository.save(user);
    }

}
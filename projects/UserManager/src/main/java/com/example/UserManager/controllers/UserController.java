package com.example.UserManager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.UserManager.entities.User;
import com.example.UserManager.services.UserService;

import java.util.ArrayList;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	
	// Mappings for the webpages to be displayed through the webapp through user interatction.
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value = "/userSearch", method = RequestMethod.GET)
    public String userSearch(ModelMap map) {  
        return "userSearch";
    }
	
	@RequestMapping(value = "/editUser", method = RequestMethod.GET)
    public String editUser(ModelMap map) {  
        return "editUser";
    }
	
	@RequestMapping(value = "/confirmation", method = RequestMethod.GET)
    public String confirmation(ModelMap map) {  
        return "confirmation";
    }
	
	// Shows all users in table. This wasn't a project requirement and has been removed from the webapp.
	@GetMapping("/users")
	public String showUsers(ModelMap model) {
		
		
		logger.info("Getting all Users");
		Iterable<User> users = userService.getAllUsers();
		
		logger.info("passing users to view");
	    model.addAttribute("users", users);    
			    
        return "users";
    }
	
	// updates the user entered in the form in the editUser.jsp page. Will update based on the user ID#.
	@PostMapping("/update")
	public String updateUser(ModelMap model, @RequestParam(value="id") int userId, @RequestParam(value="name") String name, 
			@RequestParam(value="email") String email, @RequestParam(value="password") String password) {
		
		logger.info("Getting the user by id to update");
		User us = userService.getUserById(userId);
		
		logger.info("Setting name from form into user object");
		us.setName(name);
		
		logger.info("Setting email from form into user object");
		us.setEmail(email);
		
		logger.info("Setting password from form into user object");
		us.setPassword(password);
		
		logger.info("passing user object to updateUser() method through userService");
		userService.updateUser(us);	
		
		logger.info("Passing user 'us' to Iterable<User> to add to view");
		Iterable<User> user = Arrays.asList(us);
		
		model.addAttribute("update", user);
		
		return "confirmation";
		
	}
	
	//Shows the one user entered in the form with a post method.
	@PostMapping("/user")
	public String showUser(ModelMap model, @RequestParam(value="id") int userId) {
		
		
		logger.info("Getting the user by the id");
		User us = userService.getUserById(userId);
		
		logger.info("Passing user 'us' to Iterable<User> to add to view");
		Iterable<User> user = Arrays.asList(us);
		
		logger.info("passing users to view");
	    model.addAttribute("user", user);    
	    
        return "userSearch";
    }
	
	

}
package com.hcl.springsecurityproject.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

//	@GetMapping("/")
//	public String home() {
//		return "index";
//	}
	
	@GetMapping("/user")
	public String user() {
		return ("<h1>Welcome User</h1><br><a href=\"/logout\">Logout</a>");
	}
	
}

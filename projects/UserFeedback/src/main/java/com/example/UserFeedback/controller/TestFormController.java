package com.example.UserFeedback.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestFormController {

	@GetMapping(value="/testform")
	public String showTestForm(ModelMap model) {
		//TODO: Create a JSP called "testformjsp.jsp"		
		return "testform";
	}
	
}

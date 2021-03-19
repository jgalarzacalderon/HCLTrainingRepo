package com.example.UserFeedback.controller;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.UserFeedback.entities.*;
import com.example.UserFeedback.services.FeedBackService;

@RestController
public class FeedbackController {

	@Autowired
	FeedBackService feedbackService; 
	
	Logger logger = LoggerFactory.getLogger(FeedbackController.class);

	
	@GetMapping("/feedback")
	public @ResponseBody Iterable<Feedback> getAllFeedbacks() {
        // This returns a JSON or XML with the users
        return feedbackService.getAllFeedbacks();
    }
	
	@PostMapping(path="/feedback", consumes="application/json", produces="application/json")
	public Feedback addNewFeedback(@RequestBody Feedback newFeedback) throws Exception {

		logger.info("Getting the feedback object 'newFeedback' and passing it to the addFeedback "
				+ "method for FeedbackService. This is being passed through the Post that consumes: "
				+ "application/json");
		
		return feedbackService.addFeedback(newFeedback);	
				
	}
	
	@PostMapping(path="/feedback", consumes="application/x-www-form-urlencoded", produces="application/json")
	public Feedback addNewFeedback2(Feedback newFeedback) throws Exception {

		logger.info("Getting the feedback object 'newFeedback' and passing it to the addFeedback "
				+ "method for FeedbackService. This is being passed through the Post that consumes: "
				+ "application/x-www-form-urlencoded");
		
		return feedbackService.addFeedback(newFeedback);	

	}
}

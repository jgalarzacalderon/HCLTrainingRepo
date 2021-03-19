package com.example.UserFeedback.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UserFeedback.controller.FeedbackController;
import com.example.UserFeedback.entities.Feedback;
import com.example.UserFeedback.repositories.FeedbackRepository;

@Service
public class FeedBackService {

	@Autowired
	private FeedbackRepository feedbackRepository;
	
	Logger logger = LoggerFactory.getLogger(FeedbackController.class);
	
	public Iterable<Feedback> getAllFeedbacks() {
		return feedbackRepository.findAll();
	}
	
	/*
	 * public Feedback newFeedback() { return feedbackRepository. }
	 */
	
    public Feedback getFeedbackById(int id) throws Exception {
    	Optional<Feedback> foundFeedback = feedbackRepository.findById(id);
    	
    	logger.info("requesting feedback by id " +  id);

    	if(foundFeedback.isPresent()) {
        	return(foundFeedback.get());
    	} else {
    		throw new Exception();
    	}
    	
    }
    
    public Feedback addFeedback(Feedback add) throws Exception {
    	
    	try {
			return feedbackRepository.save(add);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
    		throw new Exception();

		}
    }
	
    public Feedback createFeedback(Feedback newFeedback) {
    	return feedbackRepository.save(newFeedback);
    }
}

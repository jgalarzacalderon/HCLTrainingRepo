package com.hcl.Phase3Final.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.Phase3Final.model.Task;
import com.hcl.Phase3Final.model.User;
import com.hcl.Phase3Final.services.TaskService;
import com.hcl.Phase3Final.services.UserService;

@Controller
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@Autowired
	private UserService userService;
	
	Logger logger = LoggerFactory.getLogger(TaskController.class);
	
    @GetMapping(value="/taskpage")
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        Task task = new Task();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.addObject("task", task);
        modelAndView.setViewName("taskpage");
        return modelAndView;
    }

	@PostMapping(value = {"/taskpage"})
	public ModelAndView addTask(@Valid Task task, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        
        task.setUser(userService.findUserByUserName(auth.getName()));
		
		Task taskExists = taskService.findTaskByName(task.getName());
		
		
		if (taskExists != null) {
			bindingResult
					.rejectValue("name", "error.task",
							"There is already a task with that name in the system.");
			
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("taskpage");
		} else {
			taskService.saveTask(task);
			modelAndView.addObject("successMessage", "Task has been saved successfully");
			modelAndView.addObject("task", new Task());
			modelAndView.setViewName("taskpage");
		}
		
		return modelAndView;
	}
	
    @GetMapping(value="/updatetask")
    public ModelAndView Task(){
        ModelAndView modelAndView = new ModelAndView();
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUserName(auth.getName());
        
        Iterable<Task> temp = taskService.getAllTasks();
        
        Iterable<Task> tasks = null;
        
        ArrayList<Task> tasksArray = new ArrayList<>();
        
        String name = auth.getName();
        for(Task t: temp) {
        	if (t.getUser().getUserName().equals(name)){
				tasksArray.add(t);
			}
        }
        
        tasks  = tasksArray;
        
        modelAndView.addObject("tasks", tasks);
        
        Task task = new Task();
        modelAndView.addObject("task", task);
        modelAndView.addObject("userName", "Welcome " + user.getUserName());
        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
        modelAndView.setViewName("updatetask");
        return modelAndView;
    }
		
	@PostMapping(value="/updatetask")
	public ModelAndView updateTask(@Valid Task task, BindingResult bindingResult) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByUserName(auth.getName());
        
		Iterable<Task> temp = taskService.getAllTasks();
        Iterable<Task> tasks = null;
        ArrayList<Task> tasksArray = new ArrayList<>();
        
        String name = auth.getName();
        for(Task t: temp) {
        	if (t.getUser().getUserName().equals(name)) {
        		tasksArray.add(t);
        	}
        }
        
        Task toUpdate = taskService.getTaskById(task.getId());
        
		Boolean taskExists = false;
        for (Task t: tasksArray) {
			if (toUpdate.getId() == t.getId()) {
				// Tasks Exists in current user's task list so passing form values to toUpdate in order to prepare to save.
				toUpdate.setName(task.getName());
				toUpdate.setEndDate(task.getEndDate());
				toUpdate.setStartDate(task.getStartDate());
				toUpdate.setDescription(task.getDescription());
				taskExists = true;
			} 
        }	
        
        tasks = tasksArray;
        
		for(Task t: tasks) {
			if (toUpdate.getId() == t.getId()) {
				taskExists = true;
			}
		}
		
		if (taskExists == false) {
			bindingResult
					.rejectValue("id", "error.task",
							"An invalid task ID has been entered, please double check and try again.");
			modelAndView.addObject("tasks", tasks);
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("updatetask");
		} else {
			taskService.updateTask(toUpdate);
			modelAndView.addObject("successMessage", "Task has been updated successfully");
	        modelAndView.addObject("tasks", tasks);
			modelAndView.setViewName("updatetask");
		}
		
		return modelAndView;
		
		
	}
	
	@PostMapping(value="/deletetask")
	public ModelAndView deleteTask(@Valid Task task, BindingResult bindingResult) throws Exception {
		ModelAndView modelAndView = new ModelAndView();

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByUserName(auth.getName());
        
		Iterable<Task> temp = taskService.getAllTasks();
        Iterable<Task> tasks = null;
        ArrayList<Task> tasksArray = new ArrayList<>();
        
        String name = auth.getName();
        for(Task t: temp) {
        	if (t.getUser().getUserName().equals(name)) {
        		tasksArray.add(t);
        	}
        }
        
        tasks = tasksArray;
        
		Task toDelete = taskService.getTaskById(task.getId());
				
		Boolean taskExists = false;
		for(Task t: tasks) {
			if (toDelete.getId() == t.getId()) {
				taskExists = true;
			}
		}
		
		if (taskExists == false) {
			bindingResult
					.rejectValue("id", "error.task",
							"An invalid task ID has been entered, please double check and try again.");
			modelAndView.addObject("tasks", tasks);
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("updatetask");
		} else {
			taskService.deleteTaskById(toDelete.getId());
			modelAndView.addObject("successMessage", "Task has been deleted successfully");
	        modelAndView.addObject("tasks", tasks);
			modelAndView.setViewName("redirect:/updatetask");
		}
		
		return modelAndView;
		
		
	}
}

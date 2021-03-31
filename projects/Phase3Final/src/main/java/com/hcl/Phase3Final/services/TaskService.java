package com.hcl.Phase3Final.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hcl.Phase3Final.model.Task;
import com.hcl.Phase3Final.repositories.RoleRepository;
import com.hcl.Phase3Final.repositories.TaskRepository;
import com.hcl.Phase3Final.repositories.UserRepository;

@Service
public class TaskService {

	private TaskRepository taskRepository;
	Logger logger = LoggerFactory.getLogger(TaskService.class);

	
	@Autowired
	public TaskService(UserRepository userRepository,
					   RoleRepository roleRepository,
					   TaskRepository taskRepository,
					   BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.taskRepository = taskRepository;
	}
	
	public Iterable<Task> getAllTasks() {
		return taskRepository.findAll();
	}
	
	public Task getTaskById(int id) throws Exception {
		Optional<Task> foundTask = taskRepository.findById(id);
		
		if (!foundTask.isPresent()) {
			return (new Task());
			
		} return(foundTask.get());
	}
	
	public Task findTaskByName(String name) {
		return taskRepository.findByName(name);
	}
	
	public Task saveTask(Task task) {
		logger.info("attempting to saveTask() printing contents of Task object: ", task.toString());
		return taskRepository.save(task);
	}
	
	public void deleteTaskById(Integer id) {
		logger.info("attempting to deleteTask() printing contents of Task object: " + id);
		taskRepository.deleteById(id);
	}
	
	public Task updateTask(Task task) {
		logger.info("attempting to updateTask() printing contents of Task object: ", task.toString());		
		return taskRepository.save(task);
	}
}

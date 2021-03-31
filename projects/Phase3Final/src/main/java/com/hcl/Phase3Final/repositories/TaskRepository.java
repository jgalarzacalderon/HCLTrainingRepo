package com.hcl.Phase3Final.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.Phase3Final.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>{

	public Task findByName(String name);

	public Optional<Task> findById(Integer id);
	
}

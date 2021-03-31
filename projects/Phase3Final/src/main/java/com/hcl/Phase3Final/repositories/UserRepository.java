package com.hcl.Phase3Final.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.Phase3Final.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);
	User findByUserName(String userName);
	
}

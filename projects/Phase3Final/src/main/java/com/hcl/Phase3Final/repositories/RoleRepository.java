package com.hcl.Phase3Final.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.Phase3Final.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

	Role findByRole(String role);
	
}

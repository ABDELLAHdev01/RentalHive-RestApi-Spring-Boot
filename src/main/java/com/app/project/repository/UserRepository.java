package com.app.project.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.app.project.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	
}

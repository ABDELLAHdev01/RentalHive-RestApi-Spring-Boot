package com.app.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.project.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
}

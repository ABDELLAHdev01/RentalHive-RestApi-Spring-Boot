package com.app.project.service;

import com.app.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.project.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

    public Optional<User> findById(Long id) {
       return userRepository.findById(id);
    }
}

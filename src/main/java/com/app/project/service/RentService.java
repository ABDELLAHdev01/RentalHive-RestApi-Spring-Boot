package com.app.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.project.repository.RentRepository;

@Service
public class RentService {

	@Autowired
	private RentRepository rentRepository;
}

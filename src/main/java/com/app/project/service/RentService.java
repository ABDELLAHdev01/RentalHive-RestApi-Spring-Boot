package com.app.project.service;

import com.app.project.model.Rent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.project.repository.RentRepository;

import java.util.List;

@Service
public class RentService {

	@Autowired
	private RentRepository rentRepository;

	public List<Rent> getRentalHistoryForEquipment(String equipmentName) {
		return rentRepository.findByEquipmentsName(equipmentName);
	}
	
}

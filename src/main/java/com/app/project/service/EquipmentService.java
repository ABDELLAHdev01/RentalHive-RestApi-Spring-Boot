package com.app.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.project.model.Equipment;
import com.app.project.repository.EquipmentRepository;

@Service
public class EquipmentService {

	@Autowired
	private EquipmentRepository equipmentRepository;

	public List<Equipment> getAllEquipment(){
		return null;
	}
	public void createEquipment(Equipment equipment) {
		
	}
	public void updateEquipment(Equipment equipment) {
		
	}
	public void deleteEquipment(Long id) {
		
	}
	public List<Equipment> searchEquipmentByGivenType(String givenType){
		return equipmentRepository.searchEquipment(givenType,givenType, givenType);
	}


}

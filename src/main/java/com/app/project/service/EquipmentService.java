package com.app.project.service;

import java.util.List;
import java.util.Optional;

import com.app.project.repository.RentRepository;
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
	public void deleteEquipment(Long equipmentId) {
		Optional<Equipment> optionalEquipment = equipmentRepository.findById(equipmentId);

		if (optionalEquipment.isPresent()) {
		equipmentRepository.deleteById(equipmentId);
		}else{
			System.out.println("Equipment with ID " + equipmentId + " not found.");
		}
	}
	public List<Equipment> searchEquipmentByGivenType(String givenType){
		return equipmentRepository.searchEquipment(givenType,givenType, givenType);
	}



}

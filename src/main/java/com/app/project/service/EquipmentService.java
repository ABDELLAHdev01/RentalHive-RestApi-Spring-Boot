package com.app.project.service;

import java.util.List;
import java.util.Optional;

import com.app.project.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.project.model.Equipment;
import com.app.project.repository.EquipmentRepository;

@Service
public class EquipmentService {

	@Autowired
	private EquipmentRepository equipmentRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	public List<Equipment> getAllEquipment(){
		return null;
	}
	public Equipment createEquipment(Equipment equipment , String givenCategory) {
		if (categoryRepository.findCategoryByName(givenCategory) == null){
			return null;
		}else {
			equipment.setCategory(categoryRepository.findCategoryByName(givenCategory));
			return equipmentRepository.save(equipment);


		}
	}

	public Equipment updateEquipment(Equipment equipment ,String GivenCategory) {


			Equipment EquipmentNeedToUpdate = equipmentRepository.FindEquipment(equipment.getName());
			EquipmentNeedToUpdate.setPrice(equipment.getPrice());
			EquipmentNeedToUpdate.setStatus(equipment.getStatus());
			EquipmentNeedToUpdate.setRegistration_number(equipment.getRegistration_number());
			EquipmentNeedToUpdate.setCategory(categoryRepository.findCategoryByName(GivenCategory));
			return equipmentRepository.save(EquipmentNeedToUpdate);

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

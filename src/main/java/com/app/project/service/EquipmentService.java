package com.app.project.service;

import java.util.List;

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

	public void updateEquipment(Equipment equipment) {
		
	}
	public void deleteEquipment(Long id) {
		
	}
	public List<Equipment> searchEquipmentByGivenType(String givenType){
		return equipmentRepository.searchEquipment(givenType,givenType, givenType);
	}
}

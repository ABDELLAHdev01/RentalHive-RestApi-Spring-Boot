package com.app.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.app.project.model.Equipment;
import com.app.project.service.EquipmentService;


@RestController
@RequestMapping("/api")
public class EquipmentController {


	@Autowired
	private EquipmentService equipmentService;
	
	
	@GetMapping("/searchEquipments")
	public List<Equipment> searchUserByQuerys(@RequestParam String givenType){
		return equipmentService.searchEquipmentByGivenType(givenType);
	}

	@PostMapping(("/equipment"))
	public Equipment addEquipment(@RequestParam String name,@RequestParam String status , @RequestParam double price, @RequestParam String GivenCategory){
		Equipment givenEquipment = new Equipment();
		givenEquipment.setName(name);
		givenEquipment.setStatus(status);
		givenEquipment.setPrice(price);

		return equipmentService.createEquipment(givenEquipment, GivenCategory);
	}
}

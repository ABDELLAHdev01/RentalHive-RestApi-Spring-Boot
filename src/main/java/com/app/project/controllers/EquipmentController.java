package com.app.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}

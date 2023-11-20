package com.app.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEquipment(@PathVariable("id") Long equipmentId){
		equipmentService.deleteEquipment(equipmentId);
		return new ResponseEntity<>("Equipment successfully deleted!", HttpStatus.OK);
	}


}

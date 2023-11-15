package com.app.project.controllers;

import com.app.project.model.Equipment;
import com.app.project.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

@PostMapping("/equipment")
       public Equipment addEquipment(@RequestParam String name,@RequestParam String status , @RequestParam double price){
       Equipment givenEquipment = new Equipment();
       givenEquipment.setName(name);
       givenEquipment.setStatus(status);
       givenEquipment.setPrice(price);
       return equipmentService.createEquipment(givenEquipment);
   }
}

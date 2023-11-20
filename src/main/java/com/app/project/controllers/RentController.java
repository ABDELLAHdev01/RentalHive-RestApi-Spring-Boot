package com.app.project.controllers;

import com.app.project.model.Rent;
import com.app.project.service.RentService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rent")
public class RentController {
    @Autowired
    private RentService rentService;
    @JsonIgnore
    @GetMapping("/{equipmentName}")
    public List<Rent> getRentalHistoryForEquipment(@PathVariable String equipmentName) {
        
        return rentService.getRentalHistoryForEquipment(equipmentName);
    }

}

package com.app.project.controllers;

import com.app.project.model.Equipment;
import com.app.project.model.Rent;
import com.app.project.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.app.project.service.RentService;
import com.app.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RentController {
    @Autowired
    private RentService rentService;
    private  final UserService userService;

    @JsonIgnore
    @GetMapping("/{equipmentName}")
    public List<Rent> getRentalHistoryForEquipment(@PathVariable String equipmentName) {

        return rentService.getRentalHistoryForEquipment(equipmentName);
    }

    @GetMapping("/Rents/")
    public List<Rent> findAll() {
        return rentService.findAll();
    }

    @PostMapping("/RentEquipment")
    public Rent save(@RequestBody Rent rent) {
//        Rent rent1 = Rent.builder().equipments(null).rentDate(null).returnDate(null).user(user).build();
        return rentService.save(rent);
    }
    @DeleteMapping("/DeleteRent/{id}")
    public String delete(@PathVariable Long id) {
        return rentService.delete(id);
    }
    @PutMapping("UpdateRent/{id}")
    public  Rent update(@PathVariable Long id , @RequestBody Rent rent){
        return rentService.update(id, rent);
    }


    @GetMapping("/test")
    public String find() {
        return rentService.test();
    }

}

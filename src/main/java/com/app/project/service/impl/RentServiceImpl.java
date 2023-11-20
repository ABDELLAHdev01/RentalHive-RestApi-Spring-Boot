package com.app.project.service.impl;

import com.app.project.model.Equipment;
import com.app.project.model.Rent;
import com.app.project.model.User;
import com.app.project.repository.RentRepository;
import com.app.project.service.EquipmentService;
import com.app.project.service.RentService;
import com.app.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.*;

@Component
@RequiredArgsConstructor
public class RentServiceImpl implements RentService {

    private final RentRepository rentRepository;
    private  final UserService userService;
    private  final EquipmentService equipmentService;
    @Override
    public List<Rent> findAll() {
        return rentRepository.findAll();
    }

    @Override
    public Rent save(Rent rent) {
      User user = userService.findById(rent.getUser().getId()).orElseThrow(() -> new RuntimeException("User not found"));
        List<Long> rentedEquipmentIds = new ArrayList<>();
        for (Equipment equipment : rent.getEquipments()) {
            if(rentedEquipmentIds.contains((equipment.getId()))){
                throw new RuntimeException("You Cant rent an equipment multiple time in the same reservation");
            }
            if (equipmentService.findById(equipment.getId()) == null) {
                throw new RuntimeException("Equipment with Id " + equipment.getId() + " not found");
            }
            if(!isAllredyRented(equipment.getId() , rent.getRentDate() , rent.getReturnDate()).isEmpty()){
                throw new RuntimeException("Equipment with Id " + equipment.getId() + " is already rented");
            }
            rentedEquipmentIds.add(equipment.getId());
        }
        return rentRepository.save(rent);
    }

    @Override
    public String delete(Long id){
        Rent rent = rentRepository.findById(id).orElseThrow(() -> new RuntimeException("Rent not found!!!"));
        rentRepository.deleteById(id);
        return "You Have Deleted this Rent Successfuly";
    }


    @Override
    public Rent update(Long id, Rent rent) {
        Rent existingRent = rentRepository.findById(id).get();
        existingRent.setRentDate(rent.getRentDate());
        existingRent.setReturnDate(rent.getReturnDate());
        existingRent.setUser(rent.getUser());
        existingRent.setEquipments(rent.getEquipments());
        Rent updatedrent = rentRepository.save(existingRent);
        return updatedrent;
    }
    @Override
    public List<Rent> isAllredyRented(Long equipmentId , Date rentDate , Date returnDate){
        return rentRepository.isAlreadyRented(equipmentId , rentDate , returnDate);
    }
    @Override
    public String test() {
        return "OK";
    }
}

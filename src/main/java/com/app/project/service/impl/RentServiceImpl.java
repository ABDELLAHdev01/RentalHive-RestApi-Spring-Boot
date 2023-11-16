package com.app.project.service.impl;

import com.app.project.model.Equipment;
import com.app.project.model.Rent;
import com.app.project.model.User;
import com.app.project.repository.RentRepository;
import com.app.project.service.EquipmentService;
import com.app.project.service.RentService;
import com.app.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
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
//        User user = userService.findById(rent.getUser().getId()).orElseThrow(() -> new RuntimeException("User not found"));
        return rentRepository.save(rent);
    }

    @Override
    public String test() {
        return "OK";
    }
}

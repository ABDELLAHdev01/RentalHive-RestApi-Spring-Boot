package com.app.project.service;

import com.app.project.model.Equipment;
import com.app.project.model.Rent;
import com.app.project.model.User;
import com.app.project.repository.RentRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class RentServiceTest {
    @MockBean
    private RentRepository rentRepository;
    @Autowired
    private  RentService rentService;


    @Test
    void RentAnEquipment() {
//        List<Equipment> equipmentList =new ArrayList<>();
//        equipmentList.add(new Equipment(1L, "name", "vailiable", 102, "KLZE48E", null));
//        User user = new User();
//        user.setId(1L);
//        Rent rent = new Rent();
//        rent.setRentDate(null);
//        rent.setReturnDate(null);
//        rent.setEquipments(equipmentList);
//        rent.setUser(user);
//        when(rentRepository.save(rent)).thenReturn(rent);
//        Rent rent2 = rentService.save(rent);
//        assertEquals(rent, rent2);
    }

    @Test
    void GetAllRents(){
        when(rentRepository.findAll()).thenReturn(Stream.of(new Rent(1L , null , null , null,null)).collect(Collectors.toList()));
        assertEquals(1, rentService.findAll().size());
            }

    @Test
    public void testFindAllRents() {
        Rent rent1 = new Rent();
        Rent rent2 = new Rent();
        Rent rent3= new Rent();
        when(rentRepository.findAll()).thenReturn(Arrays.asList(rent1, rent2,rent3));
        // Call the service method
        List<Rent> allRents = rentService.findAll();
        assertEquals(3, allRents.size());
//        assertEquals(rent1, allRents.get(0));
//        assertEquals(rent2, allRents.get(1));
    }
}
package com.app.project.service;

import com.app.project.model.Equipment;
import com.app.project.model.Rent;
import com.app.project.model.User;
import com.app.project.repository.EquipmentRepository;
import com.app.project.repository.RentRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
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
//    @Autowired
//    private EquipmentService equipmentService;
@MockBean
private EquipmentRepository equipmentRepository;


    @Test
    void RentAnEquipment1() {
        List<Equipment> equipmentList =new ArrayList<>();
        equipmentList.add(new Equipment(1L, "name", "vailiable", 102, "KLZE48E", null));
        User user = new User();
        user.setId(1L);
        Rent rent = new Rent();
        rent.setRentDate(null);
        rent.setReturnDate(null);
        rent.setEquipments(equipmentList);
        rent.setUser(user);
        when(rentRepository.save(rent)).thenReturn(rent);
        Rent rent2 = rentService.save(rent);
        Rent rent1 = new Rent();
        assertEquals(rent, rent2);
    }
    @Test
    void throwExceptionIfEquipmentNotExist(){
        User user = new User();
        user.setId(1L);
        Rent rent = new Rent();
        rent.setUser(user);
        Equipment equipment1 = new Equipment();
        equipment1.setId(1L);
        Equipment equipment2 = new Equipment();
        equipment2.setId(2L);
        rent.setEquipments(List.of(equipment1, equipment2));
        when(equipmentRepository.findById(1L)).thenReturn(Optional.of(new Equipment()));
        when(equipmentRepository.findById(2L)).thenReturn(null);
        assertThrows(RuntimeException.class, () -> rentService.save(rent));
    }
    @Test
    void throwExceptionIfEquipmentAlreadyRented(){
        Rent rent = new Rent();
        Equipment equipment1 = new Equipment();
        equipment1.setId(1L);
        Equipment equipment2 = new Equipment();
        equipment2.setId(2L);
        rent.setEquipments(List.of(equipment1,equipment2));
//        rent.setRentDate(new Date(123, 9, 22));
//        rent.setReturnDate(new Date(123, 10, 22));
//        when(equipmentRepository.findById(1L)).thenReturn(Optional.of(new Equipment()));
//        when(rentRepository.isAllredyRented(1L, rent.getRentDate(), rent.getReturnDate())).thenReturn();
        assertThrows(RuntimeException.class, () -> rentService.save(rent));
    }

    @Test
    void FindAllRents1(){
        when(rentRepository.findAll()).thenReturn(Stream.of(new Rent(1L , null , null , null,null)).collect(Collectors.toList()));
        assertEquals(1, rentService.findAll().size());
    }

    @Test
    public void FindAllRents2() {
        Rent rent1 = new Rent();
        Rent rent2 = new Rent();
        Rent rent3= new Rent();
        when(rentRepository.findAll()).thenReturn(Arrays.asList(rent1, rent2,rent3));
        // Call the service method
        List<Rent> allRents = rentService.findAll();
        assertEquals(3, allRents.size());
        assertEquals(rent1, allRents.get(0));
        assertEquals(rent2, allRents.get(1));
    }
}
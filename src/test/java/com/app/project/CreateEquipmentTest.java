package com.app.project;

import com.app.project.model.Equipment;
import com.app.project.repository.EquipmentRepository;
import com.app.project.service.EquipmentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
@SpringBootTest
public class CreateEquipmentTest {

    @MockBean
    private EquipmentRepository equipmentRepository;

    @Autowired
    private EquipmentService equipmentService;


    @Test
    void CreateVaalidEquipment() {
        Equipment equipment = Equipment.builder()
                .id(2l)
                .price(23d)
                .status("available")
                .registration_number("bbb3")
                .build();
        Mockito.when(equipmentRepository.save(equipment)).thenReturn(equipment);
        equipmentService.createEquipment(equipment,"yy");
        Mockito.verify(equipmentRepository).save(equipment);

    }


    @Test
    void UpdateEquipment(){
        Equipment equipment = new Equipment();
        equipment.setPrice(22d);
        equipment.setName("dd");
        equipment.setStatus("PENDING");

        // Mock the save method of the equipmentRepository
        Mockito.when(equipmentRepository.save(equipment)).thenReturn(equipment);

        equipmentService.updateEquipment(equipment,"yy");
        Mockito.verify(equipmentRepository).save(equipment);



    }
}

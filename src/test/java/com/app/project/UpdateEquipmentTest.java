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
public class UpdateEquipmentTest {

    @MockBean
    private EquipmentRepository equipmentRepository;

    @Autowired
    private  EquipmentService equipmentService;

    @Test
    void UpdateEquipment(){
        Equipment equipment = Equipment.builder()
                .id(2l)
                .price(23d)
                .status("available")
                .registration_number("bbb3")
                .build();
        // Mock the save method of the equipmentRepository
        Mockito.when(equipmentRepository.save(equipment)).thenReturn(equipment);

        equipmentService.updateEquipment(equipment,"yy");
        Mockito.verify(equipmentRepository).save(equipment);



    }
}

package com.app.project;

import com.app.project.model.Equipment;
import com.app.project.repository.EquipmentRepository;
import com.app.project.service.EquipmentService;
import org.junit.jupiter.api.Test;
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
    // test create funciton

    }
}

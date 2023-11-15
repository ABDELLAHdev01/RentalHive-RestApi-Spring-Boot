package com.app.project;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.app.project.model.Equipment;
import com.app.project.repository.EquipmentRepository;
import com.app.project.service.EquipmentService;


@SpringBootTest
class SearchEquipmentTest {

	@MockBean
	private EquipmentRepository equipmentRepository;
	
	@Autowired
	private EquipmentService equipmentService;
	
	@Test
    void shouldReturnListOfEquipmentWhenGivenTypeIsFound() {

		String givenType = "testType";
        List<Equipment> expectedEquipment = new ArrayList<>();
        expectedEquipment.add(new Equipment(1L, "name", "vailiable", 102, "KLZE48E", null));

        when(equipmentRepository.searchEquipment(givenType, givenType, givenType)).thenReturn(expectedEquipment);

        List<Equipment> actualEquipment = equipmentService.searchEquipmentByGivenType(givenType);

        assertEquals(expectedEquipment, actualEquipment);
    }
}

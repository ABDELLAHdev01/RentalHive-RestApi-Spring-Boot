package com.app.project;

import com.app.project.model.Equipment;
import com.app.project.repository.CategoryRepository;
import com.app.project.repository.EquipmentRepository;
import com.app.project.service.EquipmentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CreateEquipmentTest {

    @MockBean
    private EquipmentRepository equipmentRepository;
    @MockBean
    private CategoryRepository categoryRepository;

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
    public void test_returnNullWhenCategoryNotFound() {
        // Arrange
        Equipment equipment = Equipment.builder()
                .id(2l)
                .price(23d)
                .status("available")
                .registration_number("bbb3")
                .build();
        String givenCategory = "category";
        Mockito.when(categoryRepository.findCategoryByName(givenCategory)).thenReturn(null);

        // Act
        Equipment result = equipmentService.createEquipment(equipment, givenCategory);

        // Assert
        assertNull(result);
    }


}

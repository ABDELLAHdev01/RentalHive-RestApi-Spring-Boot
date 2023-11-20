package com.app.project;

import com.app.project.repository.EquipmentRepository;
import com.app.project.service.EquipmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.mockito.Mock;

@SpringBootTest
public class DeleteEquipmentTest {
    @MockBean
    private EquipmentRepository equipmentRepository;

    @Autowired
    private EquipmentService equipmentService;

//    The method does not delete any equipment when given an equipmentId that does not exist in the database.
    @Test
    public void test_deleteEquipment_invalidId_noDeletion() {
        Long equipmentId = -1L;

        equipmentService.deleteEquipment(equipmentId);

        verify(equipmentRepository, never()).deleteById(equipmentId);
    }
//    The method returns void after deleting an equipment.
    @Test
    public void test_deleteEquipment_returnsVoid() {
        Long equipmentId = 1L;
        assertDoesNotThrow(() -> {
            equipmentService.deleteEquipment(equipmentId);
            return null;
        });
    }
//    The method successfully deletes an equipment with a valid equipmentId.
    @Test
    public void test_deleteEquipment_validId_equipmentDeleted() {
        Long equipmentId = 1L;
        equipmentService.deleteEquipment(equipmentId);
        verify(equipmentRepository, times(1)).deleteById(equipmentId);
    }

//    The method does not throw any exceptions when deleting an equipment.
    @Test
    public void test_deleteEquipment_noExceptionsThrown() {
        Long equipmentId = 1L;
        assertDoesNotThrow(() -> equipmentService.deleteEquipment(equipmentId));
    }
}

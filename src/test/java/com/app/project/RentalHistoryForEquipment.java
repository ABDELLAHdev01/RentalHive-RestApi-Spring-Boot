package com.app.project;

import com.app.project.model.Equipment;
import com.app.project.model.Rent;
import com.app.project.repository.RentRepository;
import com.app.project.service.RentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@SpringBootTest
public class RentalHistoryForEquipment {
    @MockBean
    private RentRepository rentRepository;
    @Autowired
    private RentService rentService;

    @Test
//    Should return a list of Rent objects when given a valid equipment name
    public void test_valid_equipment_name() {
        List<Rent> expectedRent = new ArrayList<>();

        when(rentRepository.findByEquipmentsName("trax"))
                .thenReturn(expectedRent);

        List<Rent> rentalHistory = rentService.getRentalHistoryForEquipment("trax");

        assertNotNull(rentalHistory);
        assertEquals(expectedRent, rentalHistory);
    }

//    Should return an empty list when given an equipment name that has never been
    @Test
    public void test_never_rented_equipment_name() {

        List<Rent> rentalHistory = rentService.getRentalHistoryForEquipment("test");
        assertNotNull(rentalHistory);
        assertTrue(rentalHistory.isEmpty());
    }
//    Should return an empty list when given a null equipment name
    @Test
    public void test_null_equipment_name() {

        List<Rent> rentalHistory = rentService.getRentalHistoryForEquipment(null);
        assertNotNull(rentalHistory);
        assertTrue(rentalHistory.isEmpty());
    }
//    Should return an empty list when given an empty equipment name
    @Test
    public void test_empty_equipment_name() {

        List<Rent> rentalHistory = rentService.getRentalHistoryForEquipment("");
        assertNotNull(rentalHistory);
        assertTrue(rentalHistory.isEmpty());
    }

//    Should return an empty list when given an equipment name that does not exist in the database
    @Test
    public void test_nonexistent_equipment_name() {

        List<Rent> rentalHistory = rentService.getRentalHistoryForEquipment("Equipment4");
        assertNotNull(rentalHistory);
        assertTrue(rentalHistory.isEmpty());
    }
}

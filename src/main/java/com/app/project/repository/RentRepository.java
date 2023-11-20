package com.app.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.project.model.Rent;

import java.util.Date;
import java.util.List;

@Repository
public interface RentRepository extends JpaRepository<Rent, Long> {
    @Query(value =
            "SELECT * FROM rents " +
                    "JOIN rent_equipment ON rent_equipment.rent_id = rents.id " +
                    "WHERE rent_equipment.equipment_id = :equipmentId " +
                    "AND ((rents.rent_date BETWEEN :rentStartDate AND :rentEndDate) " +
                    "OR (rents.return_date BETWEEN :rentStartDate AND :rentEndDate))",
            nativeQuery = true)
    List<Rent> isAlreadyRented(
            @Param("equipmentId") long equipmentId,
            @Param("rentStartDate") Date rentStartDate,
            @Param("rentEndDate") Date rentEndDate
    );

}

package com.app.project.repository;

import com.app.project.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.project.model.Rent;

import java.util.List;

@Repository
public interface RentRepository extends JpaRepository<Rent, Long> {


    List<Rent> findByEquipmentsName(String equipmentName);



}

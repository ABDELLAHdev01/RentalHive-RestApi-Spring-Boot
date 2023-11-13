package com.app.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.project.model.Rent;

@Repository
public interface RentRepository extends JpaRepository<Rent, Long> {

}

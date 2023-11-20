package com.app.project.service;

import com.app.project.model.Rent;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public interface RentService {
    public List<Rent> findAll();
    public Rent save(Rent rent);
    public String delete(Long id);
    public Rent update(Long id , Rent rent);
    public List<Rent> isAllredyRented(Long equipmentId , Date rentDate , Date returnDate);

   public String test();
}

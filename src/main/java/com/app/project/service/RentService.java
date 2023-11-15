package com.app.project.service;

import com.app.project.model.Rent;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface RentService {
    public List<Rent> findAll();
    public Rent save(Rent rent);
}

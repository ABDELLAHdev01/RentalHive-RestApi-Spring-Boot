package com.app.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name ="rents")
public class Rent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date returnDate;
	private Date rentDate;
	
	@ManyToOne
	@JoinColumn(name ="user_id")
	private User user;
	
	@ManyToMany
    @JoinTable(
        name = "rent_equipment",  
        joinColumns = @JoinColumn(name = "rent_id"),  
        inverseJoinColumns = @JoinColumn(name = "equipment_id")
    )
    private List<Equipment> equipments;
}

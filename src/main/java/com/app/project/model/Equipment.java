package com.app.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@Entity
@AllArgsConstructor
@Builder
@NoArgsConstructor

@Table(name ="equipments")
public class Equipment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String status;
	private double price;
	private String registration_number;
	private String address;

	@ManyToOne
	@JoinColumn(name = "category_id")
	@JsonIgnoreProperties("equipments")
	private Category category;
	@JsonIgnore
	@ManyToMany(mappedBy = "equipments")
	private List<Rent> rents;

}

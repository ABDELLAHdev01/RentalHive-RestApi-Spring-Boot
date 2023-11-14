package com.app.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.project.model.Equipment;


@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

	@Query("SELECT e FROM Equipment e WHERE e.name LIKE %?1% or e.status LIKE %?2% ")
	public List<Equipment> searchEquipment(@Param("name") String name, @Param("status") String status);
}

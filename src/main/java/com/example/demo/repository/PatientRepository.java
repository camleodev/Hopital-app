package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{
	
	@Query("select p from Patient p where p.nom like %:x%")
	Page<Patient> trouverParMotClef(@Param("x")String keyword, Pageable pageable);
}

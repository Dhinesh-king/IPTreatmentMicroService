package com.finalProject.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalProject.entity.PatientDetail;

public interface PatientDetailRepository extends JpaRepository<PatientDetail,Integer>{
	public Optional<PatientDetail> findByName(String name);

}

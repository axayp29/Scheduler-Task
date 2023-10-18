package com.scheduler.demo.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scheduler.demo.model.Doctor;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long>{
	
	 

}
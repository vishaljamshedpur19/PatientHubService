package com.patienthub.patienthub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patienthub.patienthub.Patient;


public interface PatientRepo extends JpaRepository<Patient, Long>{

}

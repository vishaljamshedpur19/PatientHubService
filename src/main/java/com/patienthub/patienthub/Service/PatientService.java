package com.patienthub.patienthub.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.patienthub.patienthub.Patient;
import com.patienthub.patienthub.Repository.PatientRepo;
import com.patienthub.patienthub.exceptions.ResourceNotFoundException;

@Service
public class PatientService {
@Autowired
    private PatientRepo  patientRepository;

    @Cacheable("patients")
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + id));
                     
    }



    public java.util.List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

  

    public Patient addPatient(Patient patient) {
    	
    	Patient patient2 = new Patient();

        return patientRepository.save(patient);
    }

    public Patient updatePatient(Long id, Patient patient) {
        patient.setId(id);
        return patientRepository.save(patient);
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

}

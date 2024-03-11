package com.patienthub.patienthub.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patienthub.patienthub.Patient;
import com.patienthub.patienthub.Service.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {

	 @Autowired
	    private PatientService patientService;

	    @GetMapping
	    public List<Patient> getAllPatients() {
	        return (List<Patient>) patientService.getAllPatients();
	    }

	    @GetMapping("/{id}")
	    public com.patienthub.patienthub.Patient getPatientById(@PathVariable Long id) {
	        return patientService.getPatientById(id);
	    }

	    @PostMapping
	    public Patient addPatient(@RequestBody Patient patient) {
	        return patientService.addPatient(patient);
	    }

	    @PutMapping("/{id}")
	    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
	        return patientService.updatePatient(id, patient);
	    }

	    @DeleteMapping("/{id}")
	    public void deletePatient(@PathVariable Long id) {
	        patientService.deletePatient(id);
	    }
}

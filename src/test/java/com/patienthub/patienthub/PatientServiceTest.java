package com.patienthub.patienthub;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.patienthub.patienthub.Repository.PatientRepo;
import com.patienthub.patienthub.Service.PatientService;
import com.patienthub.patienthub.exceptions.ResourceNotFoundException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;

public class PatientServiceTest {

    @Mock
    private PatientRepo patientRepository;

    @InjectMocks
    private PatientService patientService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetPatientById() {
        // Arrange
        Long patientId = 1L;
        Patient mockPatient = new Patient();
        mockPatient.setId(patientId);
        mockPatient.setName("John Doe");
        mockPatient.setAge(30);
        when(patientRepository.findById(patientId)).thenReturn(java.util.Optional.ofNullable(mockPatient));

        // Act
        Patient patient = patientService.getPatientById(patientId);

        // Assert
        assertNotNull(patient);
        assertEquals(patientId, patient.getId());
        assertEquals("John Doe", patient.getName());
        assertEquals(30, patient.getAge());
    }

    @Test
    public void testGetPatientByIdNotFound() {
        // Arrange
        Long patientId = 1L;
        when(patientRepository.findById(patientId)).thenReturn(java.util.Optional.empty());

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> patientService.getPatientById(patientId));
    }
}

package com.example.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Model.Patient;
@Service
public interface PatientService {

	Patient createPatient(Patient patient);

	 List<Patient> findAllPatient();

	 void deletePatient(int pid);

	 Patient updatePatient(Patient patient);

	 Patient findPatientById(int pid);

	
	
}

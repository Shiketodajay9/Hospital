package com.example.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Model.Patient;
import com.example.Repository.PatientRepository;
import com.example.Service.PatientService;

@Repository
public class PatientServiceImpl implements PatientService {
	@Autowired
	PatientRepository patientRepository;

	public Patient createPatient(Patient patient) {
		// TODO Auto-generated method stub
		return patientRepository.save(patient);

	}

	public List<Patient> findAllPatient() {
		// TODO Auto-generated method stub

		return patientRepository.findAll();
	}

	
	public void deletePatient(int pid) {
		// TODO Auto-generated method stub
	patientRepository.deleteById(pid);

	}

	
	public Patient updatePatient(Patient patient) {
		// TODO Auto-generated method stub

		Patient _patient = patientRepository.findById(patient.getP_Id()).get();
		_patient.setP_Name(patient.getP_Name());
		return patientRepository.save(_patient);
	}

	public Patient findPatientById(int pid) {
		return patientRepository.findById(pid).get();
	}


	
}

package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.Patient;
import com.example.Service.PatientService;
@RestController
public class PatientController {
	@Autowired
	PatientService patientService;

	@PostMapping("/patients")
	public Patient createPatient(@RequestBody Patient patient) {
		return patientService.createPatient(patient);
	}

	@GetMapping("/patients")
	public List<Patient> findAllPatient() {
		return patientService.findAllPatient();
	}

	@GetMapping("/patients/{id}")
	public Patient findPatientById(@PathVariable int pid) {
		return patientService.findPatientById(pid);
	}

//	@GetMapping("/patients/email/{id}")
//	public List<Patient> findPatientByEmail(@PathVariable String email) {
//	return patientService.findPatientByEmail(email);
//	}

	@DeleteMapping("/patients/{id}")
	public String deletePatient(@PathVariable int pid) {

		patientService.deletePatient(pid);
		return "Patient is deleted";
	}

	@PutMapping("/patients")
	public Patient updatePatient(@RequestBody Patient patient) {
		return patientService.updatePatient(patient);
	}

}

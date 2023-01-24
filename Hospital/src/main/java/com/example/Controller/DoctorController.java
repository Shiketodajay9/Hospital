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

import com.example.Model.Doctor;
import com.example.Service.DoctorService;
@RestController
public class DoctorController {
	@Autowired
	DoctorService doctorService;

	@PostMapping("/doctors")
	public Doctor createDoctor(@RequestBody Doctor doctor) {
		return doctorService.createDoctor(doctor);
	}

	@GetMapping("/doctors")
	public List<Doctor> findAllDoctor() {
		return doctorService.findAllDoctor();
	}

	@GetMapping("/doctors/{id}")
	public Doctor findDoctorById(@PathVariable int did) {
		return doctorService.findDoctorById(did);
	}
//
//	@GetMapping("/doctors/email/{id}")
//public List<Doctor> findUserByEmail(@PathVariable String email) {
//		return doctorService.findDoctorByEmail(email);
//	}

	@DeleteMapping("/doctors/{id}")
	public String deleteDoctor(@PathVariable int did) {

		doctorService.deleteDoctor(did);
		return "Doctor is deleted";
	}

	@PutMapping("/doctors")
	public Doctor updateDoctor(@RequestBody Doctor doctor) {
		return doctorService.updateDoctor(doctor);
	}
}

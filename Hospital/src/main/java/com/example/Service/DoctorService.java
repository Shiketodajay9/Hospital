package com.example.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Model.Doctor;
@Service
public interface DoctorService {
	 Doctor createDoctor(Doctor docter);

	 List<Doctor> findAllDoctor();

	 void deleteDoctor(int did);

	 Doctor updateDoctor(Doctor doctor);

	 Doctor findDoctorById(int did);

	


	
	
}

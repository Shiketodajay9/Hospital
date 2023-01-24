package com.example.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Service.DoctorService;
import com.example.Model.Doctor;
import com.example.Model.Patient;
import com.example.Repository.DoctorRepository;
@Repository
public class DoctorServiceImpl implements DoctorService {
	@Autowired
	DoctorRepository doctorRepository;
	
	public Doctor createDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		
		Patient patient1=new Patient();
		
		return doctorRepository.save(doctor);
		

	}

	public List<Doctor> findAllDoctor() {
		// TODO Auto-generated method stub

		return doctorRepository.findAll();
	}

	
	public void deleteDoctor(int did) {
		// TODO Auto-generated method stub
	  doctorRepository.deleteById(did);

	}

	
	public Doctor updateDoctor(Doctor doctor) {
		// TODO Auto-generated method stub

		Doctor _doctor = doctorRepository.findById(doctor.getD_Id()).get();
		_doctor.setD_Name(doctor.getD_Name());
		return doctorRepository.save(_doctor);
	}

	public Doctor findDoctorById(int did) {
		return doctorRepository.findById(did).get();
	}

	
}

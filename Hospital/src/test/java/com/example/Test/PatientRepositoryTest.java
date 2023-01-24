package com.example.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;

import com.example.Model.Doctor;
import com.example.Model.Patient;
import com.example.Repository.DoctorRepository;
import com.example.Repository.PatientRepository;
import com.example.Service.DoctorService;
import com.example.Service.PatientService;

@DataJpaTest
@AutoConfigureTestDatabase(replace =Replace.NONE)
@Rollback(false)
public class PatientRepositoryTest {
	@Autowired(required=true)
	private PatientService  patientService;
	
	@Autowired
	@MockBean
	private PatientRepository patientRepository;
	@Test
	void testcreatePatient()
	{
		List<Patient> patientList = null;
		List<Doctor> doctorList=Stream
				.of(new Doctor(1,"praju","23456", patientList),new Doctor(2,"preru","5678",patientList))
						.collect(Collectors.toList());
		Patient p=new Patient(1,"Sushant","1234",doctorList);
		Mockito.when(patientRepository.save(p)).thenReturn(p);
		assertEquals(p,patientService.createPatient(p));
	}
	void testfindAllPatient() 
	{
		List<Patient> PatientList = null;
		List<Doctor> doctorList=Stream
				.of(new Doctor(1,"praju","4567", PatientList),new Doctor(2,"preru","9876",PatientList)).collect(Collectors.toList());
		List<Patient> patient = Stream
				.of(new Patient(1,"praju","mumbai", doctorList),new Patient(2,"preru","Pune",doctorList)).collect(Collectors.toList());
		Mockito.when(patientRepository.findAll()).thenReturn(patient);
		assertEquals(1,patientService.findAllPatient().size());
	
	}	
	
	@Test
	void testdeletePatient() 
	{
		patientService.deletePatient(1);
		Mockito.verify(patientRepository).deleteById(1);
	}
}

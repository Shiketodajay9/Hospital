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
import com.example.Service.DoctorService;

@DataJpaTest
@AutoConfigureTestDatabase(replace =Replace.NONE)
@Rollback(false)
public class DoctorRepositoryTest {
	@Autowired(required=true)
	private DoctorService  doctorService;
	
	@Autowired
	@MockBean
	private DoctorRepository doctorRepository;
	
	//Test createDoctor Method
	@Test
	void testcreateDoctor( )
	{
		List<Doctor> doctorList = null;
		List<Patient> patientlist=Stream
				.of(new Patient(1,"praju","mumbai", doctorList),new Patient(2,"preru","Pune",doctorList))
						.collect(Collectors.toList());
		Doctor d=new Doctor(1,"Vikas","1234",patientlist);
		Mockito.when(doctorRepository.save(d)).thenReturn(d);
		assertEquals(d,doctorService.createDoctor(d));
	}
	
	//Test findAllDoctor Method
	@Test
	void testfindAllDoctor() 
	{
		List<Doctor> doctorList = null;
		List<Patient> patientList=Stream
				.of(new Patient(1,"praju","mumbai", doctorList),new Patient(2,"preru","Pune",doctorList)).collect(Collectors.toList());
		List<Doctor> doctor = Stream
				.of(new Doctor(1,"Ajay","2345",patientList),new Doctor(2,"kaustubh","8765",patientList)).collect(Collectors.toList());
		Mockito.when(doctorRepository.findAll()).thenReturn(doctor);
		assertEquals(1,doctorService.findAllDoctor().size());
	
	}	
	//Test DeleteDoctor Method
	@Test
	void testdeleteDoctor() 
	{
		doctorService.deleteDoctor(1);
		Mockito.verify(doctorRepository).deleteById(1);
	}
}

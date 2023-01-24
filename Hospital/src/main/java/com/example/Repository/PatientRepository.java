package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Model.Patient;

public interface PatientRepository extends JpaRepository<Patient,Integer>{

}

package com.example.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Doctor {
	 @Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
	private int D_Id;
	private String D_Name;
	private String D_Contact;
	@ManyToMany(fetch = FetchType.EAGER, mappedBy="doctor",cascade=CascadeType.ALL)
	//@JoinColumn(name="P_Id")
	   @JsonIgnoreProperties("doctor")
	private List<Patient> patient=new ArrayList<Patient>();
	
	
	
	
	public Doctor(int d_Id, String d_Name, String d_Contact, List<Patient> patient) {
		super();
		D_Id = d_Id;
		D_Name = d_Name;
		D_Contact = d_Contact;
		this.patient = patient;
	}
	public Doctor() {
		super();
	}
	public int getD_Id() {
		return D_Id;
	}
	public void setD_Id(int d_Id) {
		D_Id = d_Id;
	}
	public String getD_Name() {
		return D_Name;
	}
	public void setD_Name(String d_Name) {
		D_Name = d_Name;
	}
	public String getD_Contact() {
		return D_Contact;
	}
	public void setD_Contact(String d_Contact) {
		D_Contact = d_Contact;
	}
	public List<Patient> getPatient() {
		return patient;
	}
	public void setPatient(List<Patient> patient) {
		this.patient = patient;
	}
	
	
	
	
}

package com.example.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Patient {
	@Id
private int P_Id;
private String P_Name;
private String P_Address;
@ManyToMany(cascade=CascadeType.ALL, fetch= FetchType.EAGER)
//@JoinColumn(name="D_Id")
private List<Doctor> doctor;
public Patient(int p_Id, String p_Name, String p_Address, List<Doctor> doctorList) {
	super();
	P_Id = p_Id;
	P_Name = p_Name;
	P_Address = p_Address;
	this.doctor = doctorList;
}
public Patient() {
	super();
}
public int getP_Id() {
	return P_Id;
}
public void setP_Id(int p_Id) {
	P_Id = p_Id;
}
public String getP_Name() {
	return P_Name;
}
public void setP_Name(String p_Name) {
	P_Name = p_Name;
}
public String getP_Address() {
	return P_Address;
}
public void setP_Address(String p_Address) {
	P_Address = p_Address;
}
public List<Doctor> getDoctor() {
	return doctor;
}
public void setDoctor(List<Doctor> doctor) {
	this.doctor = doctor;
}



}

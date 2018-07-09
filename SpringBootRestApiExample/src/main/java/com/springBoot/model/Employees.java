package com.springBoot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "employees")
public class Employees {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EMPID")
	private int empId;

	@Column(name = "FULLNAME")
	private String fullName;

	@Column(name = "EMAIL")
	private String email;

	@JsonIgnore
	@Column(name = "EMPPASSWORD")
	private String empPassword;

	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	@Override
	public String toString() {
		return "Employees [empId=" + empId + ", fullName=" + fullName + ", email=" + email + ", empPassword="
				+ empPassword + "]";
	}



}

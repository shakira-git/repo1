package com.obsqura.employeeApplication.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "EMPLOYEE")

@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EMP_ID")
	private Integer id;

	@Column(name = "EMP_NAME")
	private String name;

	@Column(name = "EMP_DESIG")
	private String designation;

	@Column(name = "EMP_EMAIL")
	private String email;

}

package com.obsqura.employeeApplication.model.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class EmployeeDto {

	@JsonProperty("emp-id")
	private Integer id;

	@JsonProperty("emp-name")
	private String name;

	@JsonProperty("emp-designation")
	private String designation;

	@JsonProperty("emp-email")
	private String email;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeDto other = (EmployeeDto) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}

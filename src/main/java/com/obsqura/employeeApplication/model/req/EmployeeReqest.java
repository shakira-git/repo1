package com.obsqura.employeeApplication.model.req;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.obsqura.employeeApplication.model.dto.EmployeeDto;

import lombok.Data;

@Data
public class EmployeeReqest {

	@JsonProperty("employee")
	private List<EmployeeDto> employeeReq;

}

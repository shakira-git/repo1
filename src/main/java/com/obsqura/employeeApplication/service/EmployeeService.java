package com.obsqura.employeeApplication.service;

import java.util.List;

import com.obsqura.employeeApplication.model.entity.Employee;
import com.obsqura.employeeApplication.model.req.EmployeeReqest;

public interface EmployeeService {

	void addEmployees(EmployeeReqest employee);

	Employee getEmployee(int id);

	List<Employee> getAllEmployees();

	void deleteEmployee(int id);

	List<Employee> getEmployees(String name);
}

package com.obsqura.employeeApplication.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obsqura.employeeApplication.model.dto.EmployeeDto;
import com.obsqura.employeeApplication.model.entity.Employee;
import com.obsqura.employeeApplication.model.req.EmployeeReqest;
import com.obsqura.employeeApplication.repository.EmployeeRepository;
import com.obsqura.employeeApplication.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public void addEmployees(EmployeeReqest employee) {

		List<EmployeeDto> employees = employee.getEmployeeReq();
		List<Employee> emps = employees.stream().map(emp -> modelMapper.map(emp, Employee.class))
				.collect(Collectors.toList());
		employeeRepository.saveAll(emps);
	}

	@Override
	public Employee getEmployee(int id) {

		return employeeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Employee not present in given ID"));

	}

	@Override
	public List<Employee> getAllEmployees() {

		return (List<Employee>) employeeRepository.findAll();
	}

	@Override
	public void deleteEmployee(int id) {

		employeeRepository.deleteById(id);
	}

	@Override
	public List<Employee> getEmployees(String name) {

		return employeeRepository.findByName(name);
	}

}

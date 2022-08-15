package com.obsqura.employeeApplication.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.obsqura.employeeApplication.model.dto.EmployeeDto;
import com.obsqura.employeeApplication.model.entity.Employee;
import com.obsqura.employeeApplication.model.req.EmployeeReqest;
import com.obsqura.employeeApplication.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@Value("${spring.application.name}")
	String applicationName;

	@GetMapping("/")
	public String index() {
		return "Greetings from Obsqura Zone!! Started " + applicationName;
	}

	@RequestMapping(value = "/employee", method = RequestMethod.POST) // @PostMapping
	public String addEmployees(@RequestBody EmployeeReqest employeeReq) {
		validatepayload(employeeReq);
		employeeService.addEmployees(employeeReq);
		return "Details added succesfully";
	}

	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeDetails(@PathVariable("id") int id) {
		Employee emp = employeeService.getEmployee(id);

		return ResponseEntity.ok(emp);
	}

	@GetMapping("/employees/{name}")
	public List<Employee> getEmployeeNames(
			@Valid @Pattern(regexp = "^[a-zA-Z0-9]*$") @PathVariable("name") String name) {
		List<Employee> emp = employeeService.getEmployees(name);

		return emp;
	}

	@GetMapping("/employees")
	public List<Employee> getAllEmployeesDetails() {
		return employeeService.getAllEmployees();
	}

	@DeleteMapping("/employee/{id}")
	public String deleteEmployee(@PathVariable("id") int id) {
		employeeService.deleteEmployee(id);
		return "Student removed succesfully";

	}

	void validatepayload(EmployeeReqest employeeReq) {
//		List<Integer> duplicateEmployeeDTOS = new ArrayList<>();
//		Map<Integer, EmployeeDto> employeeDTOMap = new HashMap<>();
//		employeeReq.getEmployeeReq().forEach(item -> {
//			if (employeeDTOMap.containsKey(item.getId())) {
//				duplicateEmployeeDTOS.add(item.getId());
//			} else {
//				employeeDTOMap.put(item.getId(), item);
//			}
//		});
		
		Set<EmployeeDto> items = new HashSet<EmployeeDto>();

//		stream.filter(n -> !items.add(n))
//        .collect(Collectors.toSet())
//        .forEach(System.out::println);
		Set<EmployeeDto> items1= employeeReq.getEmployeeReq().stream().filter(emp -> !items.add(emp)).collect(Collectors.toSet());
		
		
//		List<EmployeeDto> obj = employeeReq.getEmployeeReq().stream().distinct().collect(Collectors.toList());
//		employeeReq.getEmployeeReq().stream().collect(Collectors.toSet());
//		
//		String exceptionMessage = "The data is duplicate for the ids -"
//				+ String.join(",", duplicateEmployeeDTOS.stream().map(String::valueOf).collect(Collectors.toSet()));
//		// .collect(Collectors.groupingBy(item -> item,
//		// Collectors.counting())).toString()); // will return the count also.
//		throw new RuntimeException(exceptionMessage);

		if (!CollectionUtils.isEmpty(items1)) {
			throw new RuntimeException("duplicate data found");
		}

	}

}

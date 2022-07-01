package com.grenapex.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grenapex.Entity.Employee;
import com.grenapex.Repository.EmployeeRepository;

@RestController
public class EmployeeController {

	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@PostMapping("/save")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
}

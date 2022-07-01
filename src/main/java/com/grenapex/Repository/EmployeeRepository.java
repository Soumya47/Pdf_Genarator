package com.grenapex.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.grenapex.Entity.Employee;


@Repository
public class EmployeeRepository {

	@Autowired
	private DynamoDBMapper dbMapper;
	
	public Employee save(Employee employee) {
		 dbMapper.save(employee);
		 return employee;
	}
	
}

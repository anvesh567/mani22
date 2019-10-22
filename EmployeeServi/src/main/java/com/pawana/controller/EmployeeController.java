package com.pawana.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pawana.bean.Employee;
import com.pawana.helper.EmployeeHelper;
import com.pawana.util.APIResponse;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	private EmployeeHelper employeehelper;
	
	@GetMapping("/employee/{id}")
	public APIResponse <Employee> getEmployee(@PathVariable Integer id)
	{
		return employeehelper.getEmployee(id);
		
	}
	@PostMapping("/employee")
	public APIResponse <Employee> insertEmployee(@RequestBody Employee employee) throws SQLException
	{
		return employeehelper.insertEmployee(employee);
		
	}
	@PutMapping("/employee")
	public APIResponse <Employee> updateEmployee(@RequestBody Employee employee) throws SQLException
	{
		return employeehelper.updateEmployee(employee);
		
	}
	
	@DeleteMapping("/employee/{id}")
	public APIResponse <Employee> deleteEmployee(@PathVariable Integer id) throws SQLException
	{
		return employeehelper.deleteEmployee(id);
		
	}

}

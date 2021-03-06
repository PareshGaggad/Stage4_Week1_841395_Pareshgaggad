package com.example.demo.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.exception.EmployeeNotFoundException;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/employees")
	public ArrayList<Employee> getAllEmployee(){
		return employeeService.getAllEmployee();
	}
	@PutMapping
public void updateEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFoundException{
		employeeService.updateEmployee(employee);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable String id) throws EmployeeNotFoundException{
	employeeService.deleteEmployee(id);
	}
}

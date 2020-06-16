package com.example.demo.service;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.EmployeeDao;
import com.example.demo.model.Employee;

@Service
public class EmployeeService {
	
	EmployeeDao employeeDao=new EmployeeDao();


public ArrayList<Employee> getAllEmployee(){
	return employeeDao.getAllEmployees();
}
}

package com.example.demo;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.model.Employee;


public class EmployeeDao {
	public static ArrayList<Employee> EMPLOYEE_LIST;
	public EmployeeDao() {
		// TODO Auto-generated constructor stub
		ApplicationContext context=new ClassPathXmlApplicationContext("employee.xml");
		EMPLOYEE_LIST=context.getBean("empList",ArrayList.class);
	}
	public ArrayList<Employee> getAllEmployees(){
		return EMPLOYEE_LIST;
	}

}

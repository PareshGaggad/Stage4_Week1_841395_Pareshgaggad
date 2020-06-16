package com.example.demo;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.model.Employee;
import com.example.demo.service.exception.EmployeeNotFoundException;


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

	public void updateEmployee(Employee employee) throws EmployeeNotFoundException{
		boolean flag=false;
		System.out.println(employee);
		for(int i=0;i<EMPLOYEE_LIST.size();i++) {
			if(employee.getId().equals(EMPLOYEE_LIST.get(i).getId())) {
				flag=true;
				EMPLOYEE_LIST.set(i, employee);
				
			}
		}
		if(flag==false) {
			throw new EmployeeNotFoundException();
		}
	}
	
	public void deleteEmployee(String id) throws EmployeeNotFoundException{
		boolean flag=false;
		for(int i=0;i<EMPLOYEE_LIST.size();i++) {
			if(id.equals(EMPLOYEE_LIST.get(i).getId())) {
				flag=true;
				EMPLOYEE_LIST.remove(i);
				
			}
		}
		if(flag==false) {
			throw new EmployeeNotFoundException();
		}
	}
}

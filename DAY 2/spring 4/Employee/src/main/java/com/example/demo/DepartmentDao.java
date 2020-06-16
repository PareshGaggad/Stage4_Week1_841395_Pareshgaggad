package com.example.demo;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.model.Department;

public class DepartmentDao {
	
	public static ArrayList<Department>DEPARTMENT_LIST;
	
	public ArrayList<Department>getAllDepartments() {
		ApplicationContext context=new ClassPathXmlApplicationContext("employee.xml");
		ArrayList<Department> deptList=context.getBean("deptList",ArrayList.class);
		return deptList;
	}
	

}

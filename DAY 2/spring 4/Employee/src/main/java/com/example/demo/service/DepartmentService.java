package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DepartmentDao;
import com.example.demo.model.Department;

@Service
public class DepartmentService {

	
	DepartmentDao deptdao=new DepartmentDao();
	
	public ArrayList<Department> getAllDepartments(){
		return deptdao.getAllDepartments();
	}
}

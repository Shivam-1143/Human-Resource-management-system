package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.model.Employee;
import com.masai.model.EmployeeProfileDto;

public class EmployeeProfile {
	
	void viewProfile(int empId) {
		Scanner sc = new Scanner(System.in);
		
		EmployeeDao dao = new EmployeeDaoImpl();
		try {
			EmployeeProfileDto dto = dao.getEmployeeProfile(empId);
			System.out.println("Employee Id : "+dto.getEmpId());
			System.out.println("Employee Name : "+dto.getEmpName());
			System.out.println("Address : "+dto.getAddress());
			System.out.println("Username : "+dto.getUsername());
			System.out.println("Department Id : "+dto.getDeptId());
			System.out.println("Department name : "+dto.getDeptName());
			
		} catch (Exception e) {	
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		LoginEmployee le = new LoginEmployee();
		le.employeeTasks(empId);
	}
}

package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.exceptions.EmployeeException;
import com.masai.model.Employee;

public class RegisterEmployee {
	
	void registerEmployee() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter employee id : ");
		int empId = sc.nextInt();
		
		System.out.println("Enter employee name : ");
		String name = sc.next();
		
		System.out.println("Enter address : ");
		String address = sc.next();
		
		System.out.println("Enter Email/username : ");
		String username = sc.next();
		
		System.out.println("Enter password : ");
		String password = sc.next();
		
		System.out.println("Enter department id : ");
		int deptId = sc.nextInt();
		
		Employee employee = new Employee();
		employee.setEmpId(empId);
		employee.setEmpName(name);
		employee.setAddress(address);
		employee.setUsername(username);
		employee.setPassword(password);
		employee.setDeptId(deptId);
		
		EmployeeDao dao = new EmployeeDaoImpl();
		String result;
		try {
			result = dao.registerEmployee(employee);
			System.out.println(result);
			
			System.out.println("1. Admin Login ");
			System.out.println("2. Employee Login ");
			
			int choice = sc.nextInt();
			
			switch(choice) {
			
			case 1: LoginAdmin la = new LoginAdmin();
					la.adminLogin();
			break;
			
			case 2: LoginEmployee le = new LoginEmployee();
					le.loginEmployee();
			break;
			
			}

		} catch (EmployeeException e) {
			System.out.println(e.getMessage());		
		}
		
	}
	
	void registerEmployeeByAdmin() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter employee id : ");
		int empId = sc.nextInt();
		
		System.out.println("Enter employee name : ");
		String name = sc.next();
		
		System.out.println("Enter address : ");
		String address = sc.next();
		
		System.out.println("Enter Email/username : ");
		String username = sc.next();
		
		System.out.println("Enter password : ");
		String password = sc.next();
		
		System.out.println("Enter department id : ");
		int deptId = sc.nextInt();
		
		Employee employee = new Employee();
		employee.setEmpId(empId);
		employee.setEmpName(name);
		employee.setAddress(address);
		employee.setUsername(username);
		employee.setPassword(password);
		employee.setDeptId(deptId);
		
		EmployeeDao dao = new EmployeeDaoImpl();
		String result;
		try {
			result = dao.registerEmployee(employee);
			System.out.println(result);
			
		} catch (EmployeeException e) {
			System.out.println(e.getMessage());		
		}

		LoginAdmin la = new LoginAdmin();
		la.adminTasks();
		
	}
}

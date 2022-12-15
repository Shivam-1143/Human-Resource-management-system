package com.masai.UseCases;

import java.util.Scanner;

import com.masai.Dao.EmployeeDao;
import com.masai.Dao.EmployeeDaoImpl;
import com.masai.Exceptions.EmployeeException;
import com.masai.Model.Employee;

public class RegisterEmployee {
	public static void main(String[] args) {
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
		
		Employee employee = new Employee();
		employee.setEmpId(empId);
		employee.setEmpName(name);
		employee.setAddress(address);
		employee.setUsername(username);
		employee.setPassword(password);
		
		EmployeeDao dao = new EmployeeDaoImpl();
		String result;
		try {
			result = dao.registerEmployee(employee);
			System.out.println(result);
		} catch (EmployeeException e) {
			e.printStackTrace();
		}
		
	}
}

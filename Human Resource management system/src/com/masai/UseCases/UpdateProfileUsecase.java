package com.masai.UseCases;

import java.util.Scanner;

import com.masai.Dao.EmployeeDao;
import com.masai.Dao.EmployeeDaoImpl;
import com.masai.Exceptions.EmployeeException;

public class UpdateProfileUsecase {
	
	void updateEmployeeProfile(int empId) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter new employee name : ");
		String empName = sc.next();
		
		System.out.println("Enter new address : ");
		String address = sc.next();
		
		System.out.println("Enter new username : ");
		String username = sc.next();
		
		System.out.println("Enter new department id : ");
		int deptId = sc.nextInt();
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		try {
			
			String message = dao.updateEmployeeProfile(empId,empName, address, username, deptId);
			System.out.println(message);
			
		} catch (EmployeeException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		LoginEmployee le = new LoginEmployee();
		le.employeeTasks(empId);
	}
}














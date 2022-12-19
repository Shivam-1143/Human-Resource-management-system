package com.masai.UseCases;

import java.util.Scanner;

import com.masai.Dao.EmployeeDao;
import com.masai.Dao.EmployeeDaoImpl;
import com.masai.Exceptions.EmployeeException;

public class ChangedPassword {
	
	void changedPassword(int empId) {
		Scanner sc = new Scanner(System.in);
			
		System.out.println("Enter new password : ");
		String password = sc.next();
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		try {
		
			String message = dao.changePassword(empId, password);
			System.out.println(message);
		
		} catch (EmployeeException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		LoginEmployee le = new LoginEmployee();
		le.employeeTasks(empId);
	}
}

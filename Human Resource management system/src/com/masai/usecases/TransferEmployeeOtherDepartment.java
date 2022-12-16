package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.exceptions.EmployeeException;

public class TransferEmployeeOtherDepartment {
	
	void transferEmployeeOtherDepartment() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter employee id : ");
		int empId = sc.nextInt();
		
		System.out.println("Enter new department id : ");
		int deptId = sc.nextInt();
		
		EmployeeDao dao = new EmployeeDaoImpl();
		try {
			
			String message = dao.transferEmployeeOtherDepartment(empId, deptId);
			System.out.println(message);
			
		} catch (EmployeeException e) {
			
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		}
		
		LoginAdmin la = new LoginAdmin();
		la.adminTasks();
		
	}
}

package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.DepartmentDao;
import com.masai.dao.DepartmentDaoImpl;
import com.masai.exceptions.DepartmentException;

public class AddDepartmentDetail {
	
	void addDepartment() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter department id : ");
		int deptId = sc.nextInt();
		
		System.out.println("Enter department name : ");
		String deptName = sc.next();
		
		DepartmentDao dao = new DepartmentDaoImpl();
		
		try {
			
			String result = dao.addDepartment(deptId, deptName);
			System.out.println(result);
			
		} catch (DepartmentException e) {
			System.out.println(e.getMessage());
		}
		
		LoginAdmin la = new LoginAdmin();
		la.adminTasks();
		
	}
}

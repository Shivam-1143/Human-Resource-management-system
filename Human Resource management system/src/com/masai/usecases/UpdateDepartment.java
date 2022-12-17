package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.DepartmentDao;
import com.masai.dao.DepartmentDaoImpl;
import com.masai.exceptions.DepartmentException;

public class UpdateDepartment {
	
	void updateDepartment() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter department id : ");
		int deptId = sc.nextInt();
		
		System.out.println("Enter new department name : ");
		String deptName = sc.next();
		
		DepartmentDao dao = new DepartmentDaoImpl();
		
		try {
			String result = dao.updateDepartment(deptId, deptName);
			System.out.println(result);
		} catch (DepartmentException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		LoginAdmin la = new LoginAdmin();
		la.adminTasks();
	}
}

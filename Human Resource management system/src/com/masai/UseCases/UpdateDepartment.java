package com.masai.UseCases;

import java.util.Scanner;

import com.masai.Dao.DepartmentDao;
import com.masai.Dao.DepartmentDaoImpl;
import com.masai.Exceptions.DepartmentException;

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

package com.masai.usecases;

import java.util.List;

import com.masai.dao.DepartmentDao;
import com.masai.dao.DepartmentDaoImpl;
import com.masai.exceptions.DepartmentException;
import com.masai.model.Department;

public class GetAllDepartment {
	
	void viewAllDepartment() {
		DepartmentDao dao = new DepartmentDaoImpl();
		
		try {
			List<Department> departments = dao.getAllDepartment();
			
			departments.forEach(d -> System.out.println(d));
			
		} catch (DepartmentException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		LoginAdmin la = new LoginAdmin();
		la.adminTasks();
	}
}

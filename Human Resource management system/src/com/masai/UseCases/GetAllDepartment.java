package com.masai.UseCases;

import java.util.List;

import com.masai.Dao.DepartmentDao;
import com.masai.Dao.DepartmentDaoImpl;
import com.masai.Exceptions.DepartmentException;
import com.masai.Model.Department;

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

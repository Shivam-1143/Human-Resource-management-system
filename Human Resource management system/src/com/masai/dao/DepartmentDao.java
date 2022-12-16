package com.masai.dao;

import java.util.List;

import com.masai.exceptions.DepartmentException;
import com.masai.model.Department;

public interface DepartmentDao {
	public String addDepartment(int deptId,String deptName) throws DepartmentException;
	public List<Department> getAllDepartment() throws DepartmentException;
	public String updateDepartment(int deptid,String deptName) throws DepartmentException;
	
}

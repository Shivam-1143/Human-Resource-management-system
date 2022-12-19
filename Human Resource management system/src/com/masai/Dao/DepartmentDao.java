package com.masai.Dao;

import java.util.List;

import com.masai.Exceptions.DepartmentException;
import com.masai.Model.Department;

public interface DepartmentDao {
	public String addDepartment(int deptId,String deptName) throws DepartmentException;
	public List<Department> getAllDepartment() throws DepartmentException;
	public String updateDepartment(int deptid,String deptName) throws DepartmentException;
	
}

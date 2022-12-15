package com.masai.Dao;

import com.masai.Exceptions.EmployeeException;
import com.masai.Model.Employee;

public interface EmployeeDao {
	public String registerEmployee(Employee employee) throws EmployeeException;
}

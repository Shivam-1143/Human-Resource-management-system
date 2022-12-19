package com.masai.Dao;

import com.masai.Exceptions.EmployeeException;
import com.masai.Model.Employee;
import com.masai.Model.EmployeeProfileDto;

public interface EmployeeDao {
	public String registerEmployee(Employee employee) throws EmployeeException;
	public Employee loginEmployee(String username,String password) throws EmployeeException;
	public String transferEmployeeOtherDepartment(int empId,int deptId) throws EmployeeException;
	public EmployeeProfileDto getEmployeeProfile(int empId) throws Exception;
	public String updateEmployeeProfile(int empId,String empName,String address,String username,int deptId) throws EmployeeException;
	public String changePassword(int empId,String password) throws EmployeeException;
}

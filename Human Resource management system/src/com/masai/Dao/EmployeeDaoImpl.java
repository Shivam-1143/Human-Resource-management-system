package com.masai.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.masai.Exceptions.EmployeeException;
import com.masai.Model.Employee;
import com.masai.Utility.DBUtil;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public String registerEmployee(Employee employee) throws EmployeeException {
		
		String message = "Employee not register";
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into employees values(?,?,?,?,?)");
		
			ps.setInt(1, employee.getEmpId());
			ps.setString(2, employee.getEmpName());
			ps.setString(3, employee.getAddress());
			ps.setString(4, employee.getUsername());
			ps.setString(5, employee.getPassword());
			
			int x = ps.executeUpdate();
			if(x>0)
				message = "Employee register successfully";
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EmployeeException();
		}
		
		return message;
	}

}

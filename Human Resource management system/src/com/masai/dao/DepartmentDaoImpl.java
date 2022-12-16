package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.exceptions.DepartmentException;
import com.masai.model.Department;
import com.masai.utility.DBUtil;

public class DepartmentDaoImpl implements DepartmentDao{

	@Override
	public String addDepartment(int deptId, String deptName) throws DepartmentException {
		String message = "";
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into departments values(?,?)");
			ps.setInt(1, deptId);
			ps.setString(2, deptName);
			
			int x = ps.executeUpdate();
			if(x > 0) {
				message = "Department added successfully";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DepartmentException(e.getMessage());
		}
		
		return message;
	}
	
	@Override
	public List<Department> getAllDepartment() throws DepartmentException {
		List<Department> department = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from departments");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int i = rs.getInt("dept_id");
				String n = rs.getString("dept_name");
				
				department.add(new Department(i,n));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DepartmentException(e.getMessage());
		}
		
		return department;
	}
	
	@Override
	public String updateDepartment(int deptid,String deptName) throws DepartmentException {
		String message = "record not updated";
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update departments set dept_name=? where dept_id=?");
			ps.setString(1, deptName);
			ps.setInt(2, deptid);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = x+" record updated successfully";
			}
			
		} catch (SQLException e) {
			 e.printStackTrace();
			 throw new DepartmentException(e.getMessage());
		}
		
		return message;
	}
	
}

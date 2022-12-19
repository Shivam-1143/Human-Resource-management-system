package com.masai.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.Exceptions.EmployeeException;
import com.masai.Model.Employee;
import com.masai.Model.EmployeeProfileDto;
import com.masai.Utility.DBUtil;
import com.mysql.cj.xdevapi.DbDoc;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public String registerEmployee(Employee employee) throws EmployeeException {
		
		String message = "Employee not register";
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into employees values(?,?,?,?,?,?)");
		
			ps.setInt(1, employee.getEmpId());
			ps.setString(2, employee.getEmpName());
			ps.setString(3, employee.getAddress());
			ps.setString(4, employee.getUsername());
			ps.setString(5, employee.getPassword());
			ps.setInt(6, employee.getDeptId());
			
			int x = ps.executeUpdate();
			
			if(x>0)
				message = "Employee register successfully";
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EmployeeException(e.getMessage());
		}
		
		return message;
	}
	
	@Override
	public Employee loginEmployee(String username, String password) throws EmployeeException {
		Employee employee = null;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from employees where username=? AND password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int i = rs.getInt("emp_id");
				String n = rs.getString("emp_name");
				String a = rs.getString("address");
				String u = rs.getString("username");
				String p = rs.getString("password");
				int did = rs.getInt("dept_id");
				
				employee = new Employee(i,n,a,u,p,did);
			}else {
				throw new EmployeeException("Invalid credential details");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EmployeeException(e.getMessage());
		}
		
		return employee;
	}

	@Override
	public String transferEmployeeOtherDepartment(int empId, int deptId) throws EmployeeException {
		String message = "Employee not transferred to other department";
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update employees set dept_id=? where emp_id=?");
			ps.setInt(1, deptId);
			ps.setInt(2, empId);
			
			int x = ps.executeUpdate();
			if(x > 0) {
				message = "Employee transfered in "+deptId+" department";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EmployeeException(e.getMessage());
		}
		
		return message;
		
	}
	
	@Override
	public EmployeeProfileDto getEmployeeProfile(int empId) throws Exception {
		
		EmployeeProfileDto employeeProfileDto = null;
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select e.emp_id,e.emp_name,e.address,e.username,"
								+ "d.dept_id,d.dept_name from employees e INNER JOIN "
								+ "departments d ON e.dept_id = d.dept_id AND e.emp_id=?");
			
			ps.setInt(1, empId);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int eid = rs.getInt("emp_id");
				String en = rs.getString("emp_name");
				String a = rs.getString("address");
				String u = rs.getString("username");
				int di = rs.getInt("dept_id");
				String dn = rs.getString("dept_name");
				
				employeeProfileDto = new EmployeeProfileDto(eid,en,a,u,di,dn);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
		return employeeProfileDto;
	}
	
	@Override
	public String updateEmployeeProfile(int empId,String empName,String address,String username,int deptId) throws EmployeeException {
		String message = "Profile not updated";
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update employees set emp_name=?"
													 	+ ",address=?,username=?,dept_id=?"
													 	+ " where emp_id=?");
			ps.setString(1, empName);
			ps.setString(2, address);
			ps.setString(3, username);
			ps.setInt(4, deptId);
			ps.setInt(5, empId);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = "Profile updated successfully";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EmployeeException(e.getMessage());
		}
		
		return message;
	}
	
	@Override
	public String changePassword(int empId, String password) throws EmployeeException{
		String message = "Password not changed";
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update employees set password=? where emp_Id=?");
			
			ps.setString(1, password);
			ps.setInt(2, empId);
			
			int x = ps.executeUpdate();
			if(x>0) {
				message = "Password changed successfully";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EmployeeException(e.getMessage());
		}
		
		return message;
	}
}



















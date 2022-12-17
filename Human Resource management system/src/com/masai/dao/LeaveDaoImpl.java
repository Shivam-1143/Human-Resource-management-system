package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.masai.exceptions.LeaveException;
import com.masai.model.Leave;
import com.masai.utility.DBUtil;

public class LeaveDaoImpl implements LeaveDao {

	@Override
	public String sendLeaveRequest(String title,int days,int empId) throws LeaveException {
		String message = "Request not send";
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into leaves(request_date,title,days,emp_id,status) values(now(),?,?,?,'Processing')");
			ps.setString(1, title);
			ps.setInt(2, days);
			ps.setInt(3, empId);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = "Request send successfully";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new LeaveException(e.getMessage());
		}
		
		return message;
	}
	
}

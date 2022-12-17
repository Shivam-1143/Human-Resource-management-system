package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	
	@Override
	public List<Leave> viewAllLeaveRequest(Leave leave) throws LeaveException {
		List<Leave> leaves = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from leaves");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int ri = rs.getInt("request_id");
				String dt = rs.getString("request_date");
				String t = rs.getString("title");
				int d = rs.getInt("days");
				int ei = rs.getInt("emp_id");
				String s = rs.getString("status");
				
				leaves.add(new Leave(ri,dt,t,d,ei,s));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new LeaveException("Empty!");
		}
		
		return leaves;
	}
	
	@Override
	public String updateLeaveStatus(int request_id,String status) throws LeaveException {
		String message = "Status not updated";
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update leaves set status=? where request_id=?");
			ps.setString(1, status);
			ps.setInt(2, request_id);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = "Status updated successfully";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new LeaveException(e.getMessage());
		}
		
		return message;
	}
}

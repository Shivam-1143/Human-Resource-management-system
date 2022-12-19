package com.masai.Dao;

import java.util.List;

import com.masai.Exceptions.LeaveException;
import com.masai.Model.Leave;

public interface LeaveDao {
	public String sendLeaveRequest(String title,int days,int empId) throws LeaveException;
	public List<Leave> viewAllLeaveRequest(Leave leave) throws LeaveException; 
	public String updateLeaveStatus(int request_id,String status) throws LeaveException;
}

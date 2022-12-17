package com.masai.dao;

import java.util.List;

import com.masai.exceptions.LeaveException;
import com.masai.model.Leave;

public interface LeaveDao {
	public String sendLeaveRequest(String title,int days,int empId) throws LeaveException;
	public List<Leave> viewAllLeaveRequest(Leave leave) throws LeaveException; 
	public String updateLeaveStatus(int request_id,String status) throws LeaveException;
}

package com.masai.dao;

import com.masai.exceptions.LeaveException;

public interface LeaveDao {
	public String sendLeaveRequest(String title,int days,int empId) throws LeaveException;
}

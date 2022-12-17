package com.masai.usecases;

import java.util.List;

import com.masai.dao.LeaveDao;
import com.masai.dao.LeaveDaoImpl;
import com.masai.exceptions.LeaveException;
import com.masai.model.Leave;

public class GetAllLeavesRequest {
	void viewLeavesRequests() {
		LeaveDao dao = new LeaveDaoImpl();
		
		Leave leave = new Leave();
		try {
			List<Leave> requests = dao.viewAllLeaveRequest(leave);
			
			requests.forEach(r -> System.out.println(r));
			
			UpdateLeavesRequestStatus us = new UpdateLeavesRequestStatus();
			us.requestTasks();
			
		} catch (LeaveException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			
			LoginAdmin la = new LoginAdmin();
			la.adminTasks();
		}
		
	}
}

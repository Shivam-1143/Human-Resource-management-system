package com.masai.UseCases;

import java.util.List;

import com.masai.Dao.LeaveDao;
import com.masai.Dao.LeaveDaoImpl;
import com.masai.Exceptions.LeaveException;
import com.masai.Model.Leave;

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

package com.masai.UseCases;

import java.util.Scanner;

import com.masai.Dao.LeaveDao;
import com.masai.Dao.LeaveDaoImpl;
import com.masai.Exceptions.LeaveException;

public class UpdateLeavesRequestStatus {
	
	Scanner sc = new Scanner(System.in);
	
	void updateLeaveStatus() {
		System.out.println("Enter request id : ");
		int requestId = sc.nextInt();
		System.out.println();
		System.out.println("1. Accept");
		System.out.println("2. Reject");
		
		System.out.println("\n***************************");
		
		System.out.println("Enter your choice : ");
		int choice = sc.nextInt();
		String status;
		
		switch (choice) {
		
		case 1: status = "Accept";
		break;	
		case 2: status = "Reject";
		break;
		default:
			updateLeaveStatus();
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}
		
		LeaveDao dao = new LeaveDaoImpl();
		try {
			String message = dao.updateLeaveStatus(requestId, status);
			System.out.println(message);
			
		} catch (LeaveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		requestTasks();
		
	}
	
	void requestTasks() {
		System.out.println("1. Update status");
		System.out.println("2. exit");
		
		int choice = sc.nextInt();
		
		switch (choice) {
		
		case 1: UpdateLeavesRequestStatus us = new UpdateLeavesRequestStatus();
				us.updateLeaveStatus();
		break;
		case 2: LoginAdmin la = new LoginAdmin();
				la.adminTasks();
		break;
		default:
			requestTasks();
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}
	}
}

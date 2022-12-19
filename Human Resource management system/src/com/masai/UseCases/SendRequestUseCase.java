package com.masai.UseCases;

import java.util.Scanner;

import com.masai.Dao.LeaveDao;
import com.masai.Dao.LeaveDaoImpl;
import com.masai.Exceptions.LeaveException;


public class SendRequestUseCase {
	void sendRequest(int empId) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter reason for leave : ");
		String title = sc.nextLine();
		
		System.out.println("How many days you want to leave : ");
		int days = sc.nextInt();
		
		LeaveDao dao = new LeaveDaoImpl();
		
		try {
			String message = dao.sendLeaveRequest(title, days, empId);
			System.out.println(message);
		
		} catch (LeaveException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		LoginEmployee le = new LoginEmployee();
		le.employeeTasks(empId);
	}
}

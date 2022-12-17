package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.exceptions.AdminException;

public class LoginAdmin {
	
	void adminLogin() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter username : ");
		String username = sc.next();
		
		System.out.println("Enter password : ");
		String password = sc.next();
		
		AdminDao dao = new AdminDaoImpl();
		
		try {
			
			String message = dao.loginAdmin(username, password);
			System.out.println(message);
			adminTasks();
			
		} catch (AdminException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void adminTasks() {

		Scanner sc = new Scanner(System.in);
		System.out.println("\n************************\n");
		System.out.println("1. Add Department");
		System.out.println("2. View all department");
		System.out.println("3. Update department detail");
		System.out.println("4. Register new employee");
		System.out.println("5. Transferring an employee to another department");
		System.out.println("6. View leave request");
		System.out.println("7. Logout");
		
		int choice = sc.nextInt();
		
		switch(choice) {
		
		case 1: AddDepartmentDetail add = new AddDepartmentDetail();
				add.addDepartment();
		break;
		
		case 2: GetAllDepartment view = new GetAllDepartment();
				view.viewAllDepartment();
		break;
		
		case 3: UpdateDepartment up = new UpdateDepartment();
				up.updateDepartment();
		break;
		
		case 4: RegisterEmployee re = new RegisterEmployee();
				re.registerEmployeeByAdmin();
		break;
		
		case 5: TransferEmployeeOtherDepartment td = new TransferEmployeeOtherDepartment();
				td.transferEmployeeOtherDepartment();
		break;
		
		case 6: GetAllLeavesRequest lr = new GetAllLeavesRequest();
				lr.viewLeavesRequests();
		break;
				
		case 7: System.out.println("Thank you 👋");
		
		break;
		
		default: System.out.println("Invalid choice");
				 adminTasks();
		break;
		}
	
	}
}

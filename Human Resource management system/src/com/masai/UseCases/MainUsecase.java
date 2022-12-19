package com.masai.UseCases;

import java.util.Scanner;

public class MainUsecase {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. Admin Login ");
		System.out.println("2. Employee Login ");
		System.out.println("3. Employee Register");
		
		int choice = sc.nextInt();
		
		switch(choice){
		
		case 1: LoginAdmin la = new LoginAdmin();
				la.adminLogin();
		break;
		
		case 2: LoginEmployee le = new LoginEmployee();
				le.loginEmployee();
		break;
		
		case 3: RegisterEmployee re = new RegisterEmployee();
				re.registerEmployee();
		break;
		
		default: System.out.println("Invalid choice");
				 main(args);
		break;
		
		}
	}
}

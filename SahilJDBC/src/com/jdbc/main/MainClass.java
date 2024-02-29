package com.jdbc.main;
import java.util.*;
import java.sql.*;
import com.jdbc.model.Employee;
import com.jdbc.service.DatabaseService;

public class MainClass {

	public static void main(String[] args) {
		
		DatabaseService databaseService = new DatabaseService();
		
		try(Scanner scanner = new Scanner(System.in);){
			
			boolean isRunning = true;			
		while(isRunning) {
			System.out.println("Enter Choice   :");
			System.out.println("1. Insert Data  :");
			System.out.println("2. Select All   :");
			System.out.println("3. Select Employee Id   :");
			System.out.println("4. Delete Employee   :");
			System.out.println("5. Update Employee   :");
			System.out.println("6. Exit ");
			
			Scanner sc = new Scanner(System.in);
			int choice =  sc.nextInt();
			
			
			switch(choice) {
			case 1:
				System.out.println("Enter Name , Address ,Salary ,Phone NO. ");
		
				databaseService.insertEmployee(new Employee(scanner.nextLine(),scanner.nextLine(),scanner.nextLine(),scanner.nextLine()));
				break;
			case 2:
				
				databaseService.getAllEmployees();
				break;
			case 3:
				System.out.println("Enter ID of An Employee");
				databaseService.getEmployeeById(Integer.parseInt(scanner.nextLine()));
				break;
			case 4:
				System.out.println("Enter ID of An Employee");
				databaseService.deleteEmployeeById(Integer.parseInt(scanner.nextLine()));
				break;
			case 5:
				System.out.println("Enter ID of An Employee");
				int updateId = Integer.parseInt(scanner.nextLine());
				boolean isFound= databaseService.getEmployeeById(updateId);
				
				if(isFound) {
					System.out.println("Enter name, address, salary , Phone No.");
					Employee employee =new Employee(updateId,scanner.nextLine(),scanner.nextLine(),scanner.nextLine(),scanner.nextLine());
					databaseService.updateEmployee(employee);
				}
				break;
			case 6:
				System.out.println("Thank You . Visit Again");
				isRunning = false;
				break;
			
				
			default:
				System.err.println("Invalid Choice ?");
				break;
			}
		}
	}catch(Exception e) {
		throw new RuntimeException("Somethig Went Wrong");
	}

  }

}

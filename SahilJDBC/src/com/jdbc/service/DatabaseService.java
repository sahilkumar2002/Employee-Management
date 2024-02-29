package com.jdbc.service;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jdbc.model.Employee;
import com.jdbc.util.DatabaseUtil;
import com.jdbc.util.QueryUtil;

public class DatabaseService {

	DatabaseUtil databaseUtil = new DatabaseUtil();
	
	public void insertEmployee(Employee employee) throws SQLException {
		
		try(Connection connection =  databaseUtil.getConnection();
			 PreparedStatement preparedStatement =	connection.prepareStatement(QueryUtil.insertEmployeeQuery());){
			
			preparedStatement.setString(1,employee.getEmployeeName());
			preparedStatement.setString(2,employee.getEmployeeAddress() );
			preparedStatement.setString(3,employee.getEmployeeSalary());
			preparedStatement.setString(4,employee.getEmployeePhoneNo());
			
			int rows = preparedStatement.executeUpdate();
			
			if(rows>0) {
				System.out.println("Record Created Sueecssfully ");
			}
			else {
				System.err.println("Insert Record Failed ");
			}
		}
		
	}// End of insertEmployeeQuery()
	
	 public void getAllEmployees() throws SQLException {
		 
		 try(Connection connection = databaseUtil.getConnection();
				Statement statement =  connection.createStatement();
				 ResultSet resultSet = statement.executeQuery(QueryUtil.selectAllEmployeeQuery());){
			 
			 while(resultSet.next()) {
	//call constructor	 
				 printEmployee(new Employee(resultSet.getInt("EMPLOYEE_ID"),
				 resultSet.getString("EMPLOYEE_NAME"),
				 resultSet.getString("EMPLOYEE_ADDRESS"),
				 resultSet.getString("EMPLOYEE_SALARY"),
				 resultSet.getString("PHONE_NO")
				 
				 ));
			 }
		 }
	 }//End of getAllEmployees()
	 private void printEmployee(Employee employee) {
		 System.out.println("----------Table------------------->");
		 System.out.println("Employee id:"+employee.getEmpployeeid());
		 System.out.println("Employee name:"+employee.getEmployeeName());
		 System.out.println("Employee address:"+employee.getEmployeeAddress());
		 System.out.println("Employee salary:"+employee.getEmployeeSalary());
		 System.out.println("Employee Phone NO:"+employee.getEmployeePhoneNo());
		 System.out.println("---------------------------------->");
	 }
	 
	 public boolean getEmployeeById(int id) throws SQLException {
		
		 boolean isFound = false;
		 
		 try(Connection connection = databaseUtil.getConnection();
				 Statement statement =  connection.createStatement(); 
				 ResultSet resultSet = statement.executeQuery(QueryUtil.selectEmployeeById(id));
				 ){
			 if(resultSet.next()) {
				 isFound = true;
				 printEmployee(new Employee(resultSet.getInt("EMPLOYEE_ID"),
						 resultSet.getString("EMPLOYEE_NAME"),
						 resultSet.getString("EMPLOYEE_ADDRESS"),
						 resultSet.getString("EMPLOYEE_SALARY"),
						 resultSet.getString("PHONE_NO")
						 ));
			 }else {
				 System.err.println("Record Not Found For Id :"+id);
			 }
		 }
		 return isFound;
	 }//End of getEmployeeById()
	 
	 public void deleteEmployeeById(int employeeId)throws SQLException {
		 
		 try(Connection connection = databaseUtil.getConnection();
				 Statement statement =  connection.createStatement(); ){
				 int rows = statement.executeUpdate(QueryUtil.deleteEmployeeById(employeeId));
				
				if(rows > 0) {
					System.out.print("Record Deleted Successfully");
				}else {
					System.err.println("Somthing Went Wrong");
				}
			 
		 }
	 }//End of deleteEmployeeById()
	 
	 public void updateEmployee(Employee employee) throws SQLException{
		 try(Connection connection = databaseUtil.getConnection();
				PreparedStatement preparedStatement =connection.prepareStatement( QueryUtil.updateEmployeeQuery(employee.getEmpployeeid())) ){
			preparedStatement.setString(1, employee.getEmployeeName());
			preparedStatement.setString(2, employee.getEmployeeAddress());
			preparedStatement.setString(3, employee.getEmployeeSalary());
			preparedStatement.setString(4, employee.getEmployeePhoneNo());
			
			int rows=preparedStatement.executeUpdate();
			if(rows>0) {
				System.out.println("Record Updated Successfully.");
			}else {
				System.out.println("Failed to update record.");
			}
		 }
		 
	 }//End of updateEmployee()
}

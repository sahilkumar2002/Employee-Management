package com.jdbc.student;
import java.sql.*;
public class StudentDatabase {
	
	

	public static void main(String[] args) {
		
       try {
		Class.forName("com.mysql.cj.jdbc.Driver");
       }catch(ClassNotFoundException e) {
    	   System.out.println(e.getMessage());
       }
       
       try {
    	   Connection  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","anitadhawanak47");
    	   Statement statement = connection.createStatement();
    	   String query = "select * from student";
    	   ResultSet resultSet = statement.executeQuery(query);
    	   while(resultSet.next()) {
    		
    		   System.out.println("ID  :"+resultSet.getString("id"));
    		   System.out.println("NAME :"+resultSet.getString("name"));
    		   System.out.println("AGE  :"+resultSet.getString("age"));
    		   System.out.println("MARKS:"+resultSet.getString("marks"));
    		   
    		   
    	   }
    	   
    	   
    	   
       }catch(SQLException e) {
    	   System.out.println(e.getMessage());
    	   
       }
       
       
       
       
       
	}

}
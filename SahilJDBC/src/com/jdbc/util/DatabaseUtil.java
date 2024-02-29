package com.jdbc.util;
import java.sql.*;

public class DatabaseUtil {

	
	public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/jdbcdb";
	public static final String USERNAME = "root";
	public static final String PASSWORD ="anitadhawanak47";
	
	public DatabaseUtil() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	       }catch(Exception e) {
	    	   System.out.println(e.getMessage());
	       }
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
	}
}

package com.jdbc.model;

public class Employee {
	
	private int  empployeeid;
	private String employeeName;
	private String employeeAddress;
	private String employeeSalary;
	private String employeePhoneNo;
	
	
	
	
	public Employee(String employeeName, String employeeAddress, String employeeSalary, String employeePhoneNo) {
		super();
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
		this.employeeSalary = employeeSalary;
		this.employeePhoneNo = employeePhoneNo;
	}
	
	
	
	public Employee(int empployeeid, String employeeName, String employeeAddress, String employeeSalary, String employeePhoneNo) {
		super();
		this.empployeeid = empployeeid;
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
		this.employeeSalary = employeeSalary;
		this.employeePhoneNo = employeePhoneNo;
	}



	public int getEmpployeeid() {
		return empployeeid;
	}
	public void setEmpployeeid(int empployeeid) {
		this.empployeeid = empployeeid;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	public String getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(String employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	public String getEmployeePhoneNo() {
		return employeePhoneNo;
	}
	public void setEmployeePhoneNo(String employeePhoneNo) {
		this.employeePhoneNo = employeePhoneNo;
	}

	
	

}

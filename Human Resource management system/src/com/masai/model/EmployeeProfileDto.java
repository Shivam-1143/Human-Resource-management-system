package com.masai.model;

public class EmployeeProfileDto {
	private int empId;
	private String empName;
	private String address ;
	private String username ;
	
	private int deptId;
	private String deptName;
	
	public EmployeeProfileDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public EmployeeProfileDto(int empId, String empName, String address, String username, int deptId,String deptName) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.address = address;
		this.username = username;
		this.deptId = deptId;
		this.deptName = deptName;
	}

	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	@Override
	public String toString() {
		return "EmployeeProfileDto [empId=" + empId + ", empName=" + empName + ", address=" + address + ", username="
				+ username + ", deptId=" + deptId + ", deptName=" + deptName + "]";
	}
	
	
}

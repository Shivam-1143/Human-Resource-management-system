package com.masai.Model;

import java.util.Date;

public class Leave {
	private int requestId;
	private String requestDate;
	private String title;
	private int days;
	private int empId;
	private String status;
	
	public Leave() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Leave(int requestId, String requestDate, String title, int days, int empId, String status) {
		super();
		this.requestId = requestId;
		this.requestDate = requestDate;
		this.title = title;
		this.days = days;
		this.empId = empId;
		this.status = status;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Leave [requestId=" + requestId + ", requestDate=" + requestDate + ", title=" + title + ", days=" + days
				+ ", empId=" + empId + ", status=" + status + "]";
	}
	
	
}

package com.citi.trs.model;

public class LoginResponse {

	private String status;

	public LoginResponse(String status){
		this.status=status;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}

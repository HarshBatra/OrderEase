package com.cdac.orderease.dto;

public class LoginUserDTO {
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LoginUserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginUserDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
}

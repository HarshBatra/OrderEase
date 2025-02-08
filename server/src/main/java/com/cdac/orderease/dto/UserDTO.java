package com.cdac.orderease.dto;

import java.util.ArrayList;
import java.util.List;

import com.cdac.orderease.entity.Order;

public class UserDTO {
	private Long userId;
	private String username;
	private String userEmail;
	private String password;
	private String phoneNo;
	private String role;
	private List<Order> orderList = new ArrayList<>();
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getRole() { 
        return role;
    }
	public void setRole(String roles) { 
        this.role = roles;
    }
	public List<Order> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}
	public UserDTO() {
		super();
	}
	public UserDTO(Long userId, String username, String userEmail, String password, String phoneNo, String  roles) {
		super();
		this.userId = userId;
		this.username = username;
		this.userEmail = userEmail;
		this.password = password;
		this.phoneNo = phoneNo;
		this.role = roles;
	}
	public UserDTO(Long userId, String username, String userEmail, String password, String phoneNo, String roles,
			List<Order> orderList) {
		super();
		this.userId = userId;
		this.username = username;
		this.userEmail = userEmail;
		this.password = password;
		this.phoneNo = phoneNo;
		this.role = roles;
		this.orderList = orderList;
	}
	
}

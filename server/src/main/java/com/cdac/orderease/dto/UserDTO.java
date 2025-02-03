package com.cdac.orderease.dto;

import java.util.ArrayList;
import java.util.List;

import com.cdac.orderease.entity.Order;
import com.cdac.orderease.enums.UserRoles;

public class UserDTO {
	private Long userId;
	private String username;
	private String userEmail;
	private String password;
	private String phoneNo;
	private UserRoles roles;
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
	public UserRoles getRoles() {
		return roles;
	}
	public void setRoles(UserRoles roles) {
		this.roles = roles;
	}
	public List<Order> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDTO(Long userId, String username, String userEmail, String password, String phoneNo, UserRoles roles) {
		super();
		this.userId = userId;
		this.username = username;
		this.userEmail = userEmail;
		this.password = password;
		this.phoneNo = phoneNo;
		this.roles = roles;
	}
	public UserDTO(Long userId, String username, String userEmail, String password, String phoneNo, UserRoles roles,
			List<Order> orderList) {
		super();
		this.userId = userId;
		this.username = username;
		this.userEmail = userEmail;
		this.password = password;
		this.phoneNo = phoneNo;
		this.roles = roles;
		this.orderList = orderList;
	}
	
}

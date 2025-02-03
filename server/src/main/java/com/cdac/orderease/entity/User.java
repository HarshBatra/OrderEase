package com.cdac.orderease.entity;

import java.util.ArrayList;
import java.util.List;

import com.cdac.orderease.enums.UserRoles;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userid")
	private Long userId;
	@Column(name = "username")
	private String username;
	@Column(name = "useremail")
	private String userEmail;
	@Column(name = "userpassword")
	private String password;
	@Column(name = "phoneNo")
	private String phoneNo;
	@Column(name = "roles")
	private UserRoles roles;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonIgnore
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
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Long userId, String username, String userEmail, String password, String phoneNo, UserRoles roles) {
		super();
		this.userId = userId;
		this.username = username;
		this.userEmail = userEmail;
		this.password = password;
		this.phoneNo = phoneNo;
		this.roles = roles;
	}
}

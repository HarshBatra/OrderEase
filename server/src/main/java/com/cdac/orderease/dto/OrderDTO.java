package com.cdac.orderease.dto;

import java.time.LocalDateTime;

import com.cdac.orderease.entity.User;
import com.cdac.orderease.enums.OrderStatus;

public class OrderDTO {
	
	private Long orderId;
	private LocalDateTime orderDateTime;
	private OrderStatus orderStatus;
	private User user;
	public OrderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDTO(Long orderId, LocalDateTime orderDateTime, OrderStatus orderStatus, User user) {
		super();
		this.orderId = orderId;
		this.orderDateTime = orderDateTime;
		this.orderStatus = orderStatus;
		this.user = user;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public LocalDateTime getOrderDateTime() {
		return orderDateTime;
	}
	public void setOrderDateTime(LocalDateTime orderDateTime) {
		this.orderDateTime = orderDateTime;
	}
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}

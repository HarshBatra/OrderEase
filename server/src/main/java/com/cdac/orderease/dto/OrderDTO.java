package com.cdac.orderease.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.cdac.orderease.entity.OrderItems;
import com.cdac.orderease.entity.Users;
import com.cdac.orderease.enums.OrderStatus;

public class OrderDTO {
	
	private Long orderId;
	private LocalDateTime orderDateTime;
	private OrderStatus orderStatus;
	private Users user;
	private List<OrderItems> orderItemList = new ArrayList<>();
	
	public OrderDTO() {
		super();
	}
	public OrderDTO(Long orderId, LocalDateTime orderDateTime, OrderStatus orderStatus, Users user) {
		super();
		this.orderId = orderId;
		this.orderDateTime = orderDateTime;
		this.orderStatus = orderStatus;
		this.user = user;
	}
	public OrderDTO(Long orderId, LocalDateTime orderDateTime, OrderStatus orderStatus, Users user,
			List<OrderItems> orderItemList) {
		super();
		this.orderId = orderId;
		this.orderDateTime = orderDateTime;
		this.orderStatus = orderStatus;
		this.user = user;
		this.orderItemList = orderItemList;
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
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public List<OrderItems> getOrderItemList() {
		return orderItemList;
	}
	public void setOrderItemList(List<OrderItems> orderItemList) {
		this.orderItemList = orderItemList;
	}
	
}

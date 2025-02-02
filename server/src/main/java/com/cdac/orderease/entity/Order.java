package com.cdac.orderease.entity;

import java.time.LocalDateTime;

import com.cdac.orderease.enums.OrderStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderid")
	private Long orderId;
	@Column(name = "orderdatetime")
	private LocalDateTime orderDateTime;
	@Column(name = "orderstatus")
	private OrderStatus orderStatus;
	
	@ManyToOne
	@JoinColumn(name = "userid")
	private User user;

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

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Long orderId, LocalDateTime orderDateTime, OrderStatus orderStatus, User user) {
		super();
		this.orderId = orderId;
		this.orderDateTime = orderDateTime;
		this.orderStatus = orderStatus;
		this.user = user;
	}
	
}

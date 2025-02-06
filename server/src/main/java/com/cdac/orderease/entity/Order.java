package com.cdac.orderease.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.cdac.orderease.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<OrderItems> orderItemsList = new ArrayList<>();
	
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

	public List<OrderItems> getOrderItemsList() {
		return orderItemsList;
	}

	public void setOrderItemsList(List<OrderItems> orderItemsList) {
		this.orderItemsList = orderItemsList;
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

	public Order(Long orderId, LocalDateTime orderDateTime, OrderStatus orderStatus, User user,
			List<OrderItems> orderItemsList) {
		super();
		this.orderId = orderId;
		this.orderDateTime = orderDateTime;
		this.orderStatus = orderStatus;
		this.user = user;
		this.orderItemsList = orderItemsList;
	}
	
}

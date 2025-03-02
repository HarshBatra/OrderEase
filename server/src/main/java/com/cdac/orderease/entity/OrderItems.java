package com.cdac.orderease.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orderitems")
public class OrderItems {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderitemid")
	private Long orderItemId;
	
	@ManyToOne
	@JoinColumn(name = "itemid")
	private Menu items;
	
	@ManyToOne
	@JoinColumn(name = "orderid")
	private Order order;
	
	@Column(name = "quantity")
	private Long quantity;

	public Long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Menu getItems() {
		return items;
	}

	public void setItems(Menu items) {
		this.items = items;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public OrderItems() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItems(Long orderItemId, Menu items, Order order, Long quantity) {
		super();
		this.orderItemId = orderItemId;
		this.items = items;
		this.order = order;
		this.quantity = quantity;
	}
	
	
	
}

package com.cdac.orderease.dto;

import com.cdac.orderease.entity.Menu;
import com.cdac.orderease.entity.Order;

public class OrderItemsDTO {
	
	Long orderItemId;
	Menu items;
	Order order;
	Long quantity;
	public OrderItemsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderItemsDTO(Long orderItemId, Menu items, Order order, Long quantity) {
		super();
		this.orderItemId = orderItemId;
		this.items = items;
		this.order = order;
		this.quantity = quantity;
	}
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
	
}

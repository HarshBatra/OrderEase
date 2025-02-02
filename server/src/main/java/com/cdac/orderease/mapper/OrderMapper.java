package com.cdac.orderease.mapper;

import com.cdac.orderease.dto.OrderDTO;
import com.cdac.orderease.entity.Order;

public class OrderMapper {
	public static Order mapOrderDtoToOrder(OrderDTO orderDto) {
		Order order = new Order();
		order.setOrderId(orderDto.getOrderId());
		order.setOrderStatus(orderDto.getOrderStatus());
		order.setOrderDateTime(orderDto.getOrderDateTime());
		order.setUser(orderDto.getUser());
		return order;
	}
	
	public static OrderDTO mapOrderToOrderDto(Order order) {
		OrderDTO orderDto = new OrderDTO();
		orderDto.setOrderId(order.getOrderId());
		orderDto.setOrderStatus(order.getOrderStatus());
		orderDto.setOrderDateTime(order.getOrderDateTime());
		orderDto.setUser(order.getUser());
		return orderDto;
	}
}

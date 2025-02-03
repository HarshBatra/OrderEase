package com.cdac.orderease.mapper;

import com.cdac.orderease.dto.OrderItemsDTO;
import com.cdac.orderease.entity.OrderItems;

public class OrderItemsMapper {
	public static OrderItems mapOrderItemsDtoToOrderItems(OrderItemsDTO orderItemsDto) {
		OrderItems orderItems = new OrderItems();
		orderItems.setOrderItemId(orderItemsDto.getOrderItemId());
		orderItems.setItems(orderItemsDto.getItems());
		orderItems.setOrder(orderItemsDto.getOrder());
		orderItems.setQuantity(orderItemsDto.getQuantity());
		return orderItems;
	}
	
	public static OrderItemsDTO mapOrderItemsToOrderItemsDto(OrderItems orderItems) {
		OrderItemsDTO orderItemsDto = new OrderItemsDTO();
		orderItemsDto.setOrderItemId(orderItems.getOrderItemId());
		orderItemsDto.setItems(orderItems.getItems());
		orderItemsDto.setOrder(orderItems.getOrder());
		orderItemsDto.setQuantity(orderItems.getQuantity());
		return orderItemsDto;
	}
}

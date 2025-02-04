package com.cdac.orderease.service;

import java.util.List;

import com.cdac.orderease.dto.OrderItemsDTO;

public interface OrderItemsService {

	OrderItemsDTO addOrderItems(OrderItemsDTO orderItemsDTO);

	List<OrderItemsDTO> addListOfOrderItems(List<OrderItemsDTO> orderItemsDtoList);

}

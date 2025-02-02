package com.cdac.orderease.service;

import java.util.List;

import com.cdac.orderease.dto.OrderDTO;
import com.cdac.orderease.exception.OrderNotFoundException;

public interface OrderService {

	OrderDTO addOrder(OrderDTO orderDto);

	List<OrderDTO> addListOfOrders(List<OrderDTO> orderDtoList);

	OrderDTO updateOrder(Long orderId, OrderDTO orderDto) throws OrderNotFoundException;

}

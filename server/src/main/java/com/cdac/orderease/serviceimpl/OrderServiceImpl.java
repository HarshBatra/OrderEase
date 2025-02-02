package com.cdac.orderease.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.orderease.dto.OrderDTO;
import com.cdac.orderease.entity.Order;
import com.cdac.orderease.exception.OrderNotFoundException;
import com.cdac.orderease.mapper.OrderMapper;
import com.cdac.orderease.repository.OrderRepository;
import com.cdac.orderease.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public OrderDTO addOrder(OrderDTO orderDto) {
		Order order = OrderMapper.mapOrderDtoToOrder(orderDto);
		Order savedOrder = orderRepository.save(order);
		return OrderMapper.mapOrderToOrderDto(savedOrder);
	}

	@Override
	public List<OrderDTO> addListOfOrders(List<OrderDTO> orderDtoList) {
		List<Order> orderList = new ArrayList<>();
		for(OrderDTO dto : orderDtoList) {
			orderList.add(OrderMapper.mapOrderDtoToOrder(dto));
		}
		List<Order> saveAllOrders = orderRepository.saveAll(orderList);
		return saveAllOrders.stream()
				.map(OrderMapper::mapOrderToOrderDto)
				.collect(Collectors.toList());
	}

	@Override
	public OrderDTO updateOrder(Long orderId, OrderDTO orderDto) throws OrderNotFoundException {
		Optional<Order> orderById = orderRepository.findById(orderId);
		if(orderById.isEmpty()) {
			throw new OrderNotFoundException("Order with order id : " + orderId + " not found");
		}
		Order order = OrderMapper.mapOrderDtoToOrder(orderDto);
		Order savedOrder = orderRepository.save(order);
		
		return OrderMapper.mapOrderToOrderDto(savedOrder);
	}
	
}

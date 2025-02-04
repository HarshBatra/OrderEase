package com.cdac.orderease.serviceimpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.orderease.dto.OrderItemsDTO;
import com.cdac.orderease.entity.OrderItems;
import com.cdac.orderease.mapper.OrderItemsMapper;
import com.cdac.orderease.repository.OrderItemsRepository;
import com.cdac.orderease.service.OrderItemsService;

@Service
public class OrderItemsServiceImpl implements OrderItemsService {

	@Autowired
	OrderItemsRepository orderItemsRepository;
	
	@Override
	public OrderItemsDTO addOrderItems(OrderItemsDTO orderItemsDTO) {
		OrderItems orderItems = OrderItemsMapper.mapOrderItemsDtoToOrderItems(orderItemsDTO);
		OrderItems savedOrderItems = orderItemsRepository.save(orderItems);
		return OrderItemsMapper.mapOrderItemsToOrderItemsDto(savedOrderItems);
	}

	@Override
	public List<OrderItemsDTO> addListOfOrderItems(List<OrderItemsDTO> orderItemsDtoList) {
		List<OrderItems> orderItemsList = new ArrayList<>();
		for (OrderItemsDTO dto : orderItemsDtoList) {
			orderItemsList.add(OrderItemsMapper.mapOrderItemsDtoToOrderItems(dto));
		}
		List<OrderItems> savedOrderItemsList = orderItemsRepository.saveAll(orderItemsList);
		return savedOrderItemsList.stream()
				.map(OrderItemsMapper::mapOrderItemsToOrderItemsDto)
				.collect(Collectors.toList());
	}
	
}

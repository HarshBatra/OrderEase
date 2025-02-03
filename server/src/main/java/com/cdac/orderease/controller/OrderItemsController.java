package com.cdac.orderease.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.orderease.dto.OrderItemsDTO;
import com.cdac.orderease.service.OrderItemsService;

@RestController
@RequestMapping("/orderitems")
public class OrderItemsController {
	
	@Autowired
	private OrderItemsService orderItemsService;
	
	public ResponseEntity<OrderItemsDTO> addOrderItems(@RequestBody OrderItemsDTO orderItemsDTO) {
		OrderItemsDTO savedOrderItem = orderItemsService.addOrderItems(orderItemsDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedOrderItem);
	}
	
}

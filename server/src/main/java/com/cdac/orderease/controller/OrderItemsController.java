package com.cdac.orderease.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping("/add")
	public ResponseEntity<OrderItemsDTO> addOrderItems(@RequestBody OrderItemsDTO orderItemsDTO) {
		OrderItemsDTO savedOrderItem = orderItemsService.addOrderItems(orderItemsDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedOrderItem);
	}
	
	@PostMapping("/addList")
	public ResponseEntity<List<OrderItemsDTO>> addListOfOrderItems(@RequestBody List<OrderItemsDTO> orderItemsDtoList) {
		List<OrderItemsDTO> saveOrderItemsList = orderItemsService.addListOfOrderItems(orderItemsDtoList);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveOrderItemsList);
	}
	
}

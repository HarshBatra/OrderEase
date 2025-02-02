package com.cdac.orderease.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.orderease.dto.OrderDTO;
import com.cdac.orderease.exception.OrderNotFoundException;
import com.cdac.orderease.service.OrderService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/add")
	public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDto) {
		OrderDTO savedOrder = orderService.addOrder(orderDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedOrder);
	}
	
	@PostMapping("allMany")
	public ResponseEntity<List<OrderDTO>> createListOfOrder(@RequestBody List<OrderDTO> orderDtoList) {
		List<OrderDTO> savedOrder = orderService.addListOfOrders(orderDtoList);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedOrder);
	}
	
	@PutMapping("/{orderId}")
	public ResponseEntity<OrderDTO> updateOrder(@PathVariable Long orderId, @RequestBody OrderDTO orderDto) throws OrderNotFoundException {
		OrderDTO savedOrder = orderService.updateOrder(orderId, orderDto);
		return ResponseEntity.ok(savedOrder);
	}
}

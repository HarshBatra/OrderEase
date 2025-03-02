package com.cdac.orderease.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.orderease.dto.OrderItemsDTO;
import com.cdac.orderease.service.OrderItemsService;

@RestController
@RequestMapping("")
@PreAuthorize("hasAuthority('ROLE_USER')")
public class OrderItemsController {
	
	@Autowired
	private OrderItemsService orderItemsService;
	
	@PreAuthorize("hasRole('USER')")
	@PostMapping("/u/orderitems/add")
	public ResponseEntity<OrderItemsDTO> addOrderItems(@RequestBody OrderItemsDTO orderItemsDTO) {
		OrderItemsDTO savedOrderItem = orderItemsService.addOrderItems(orderItemsDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedOrderItem);
	}

	@PreAuthorize("hasRole('USER')")
	@PostMapping("/u/orderitems/addList")
	public ResponseEntity<List<OrderItemsDTO>> addListOfOrderItems(@RequestBody List<OrderItemsDTO> orderItemsDtoList) {
		List<OrderItemsDTO> saveOrderItemsList = orderItemsService.addListOfOrderItems(orderItemsDtoList);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveOrderItemsList);
	}	
}
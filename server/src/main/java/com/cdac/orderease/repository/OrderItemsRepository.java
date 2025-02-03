package com.cdac.orderease.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.orderease.entity.OrderItems;

public interface OrderItemsRepository extends JpaRepository<OrderItems, Long> {

}

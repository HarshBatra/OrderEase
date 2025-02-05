package com.cdac.orderease.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.orderease.entity.Payments;

public interface PaymentRepository extends JpaRepository<Payments, Long>{

	Payments findByRazorpayOrderId(String razorpayId);

}

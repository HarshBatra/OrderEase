package com.cdac.orderease.entity;

import com.cdac.orderease.enums.PaymentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "payments")
public class Payments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "paymentid")
	private Long paymentId;
	@Column(name = "razorpayorderid")
	private String razorpayOrderId;
	@Column(name = "amount")
	private Double amount;
	@Column(name = "paymentstatus")
	private PaymentStatus paymentStatus;
	
	@Column(name = "orderid")
	private Long orderId;

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public String getRazorpayOrderId() {
		return razorpayOrderId;
	}

	public void setRazorpayOrderId(String razorpayOrderId) {
		this.razorpayOrderId = razorpayOrderId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Payments() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payments(Long paymentId, String razorpayOrderId, Double amount, PaymentStatus paymentStatus, Long orderId) {
		super();
		this.paymentId = paymentId;
		this.razorpayOrderId = razorpayOrderId;
		this.amount = amount;
		this.paymentStatus = paymentStatus;
		this.orderId = orderId;
	}
	
	
}

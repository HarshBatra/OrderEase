package com.cdac.orderease.dto;

import com.cdac.orderease.entity.Order;

public class PaymentsDTO {
	
	private Long paymentId;
	private Order orderId;
	private String razorpayOrderId;
	private Double amount;
	private String paymentStatus;
	
	
	public Long getPaymentId() {
		return paymentId;
	}


	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}


	public Order getOrderId() {
		return orderId;
	}


	public void setOrderId(Order orderId) {
		this.orderId = orderId;
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


	public String getPaymentStatus() {
		return paymentStatus;
	}


	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	
	public PaymentsDTO(Long paymentId, Order order, String razorpayOrderId, Double amount, String paymentStatus) {
		super();
		this.paymentId = paymentId;
		this.orderId = order;
		this.razorpayOrderId = razorpayOrderId;
		this.amount = amount;
		this.paymentStatus = paymentStatus;
	}
	

	public PaymentsDTO() {
		super();
	}


	@Override
	public String toString() {
		return "Payments [paymentId=" + paymentId + ", orderId=" + orderId + ", razorpayOrderId=" + razorpayOrderId
				+ ", amount=" + amount + ", paymentStatus=" + paymentStatus + "]";
	}
	
	
}

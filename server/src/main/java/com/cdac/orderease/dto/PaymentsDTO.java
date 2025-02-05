package com.cdac.orderease.dto;

import com.cdac.orderease.enums.PaymentStatus;

public class PaymentsDTO {
	
	private Long paymentId;
	private Long orderId;
	private String razorpayOrderId;
	private Double amount;
	private PaymentStatus paymentStatus;
	public PaymentsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PaymentsDTO(Long paymentId, Long orderId, String razorpayOrderId, Double amount,
			PaymentStatus paymentStatus) {
		super();
		this.paymentId = paymentId;
		this.orderId = orderId;
		this.razorpayOrderId = razorpayOrderId;
		this.amount = amount;
		this.paymentStatus = paymentStatus;
	}
	public Long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
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
	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
}

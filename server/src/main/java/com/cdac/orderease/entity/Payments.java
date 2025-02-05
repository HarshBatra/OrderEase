package com.cdac.orderease.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Payments")
public class Payments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long paymentId;
	private Long orderId;
	private String razorpayOrderId;
	private Double amount;
	private String paymentStatus;
	
	
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


	public String getPaymentStatus() {
		return paymentStatus;
	}


	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	
	public Payments(Long paymentId, Long orderId, String razorpayOrderId, Double amount, String paymentStatus) {
		super();
		this.paymentId = paymentId;
		this.orderId = orderId;
		this.razorpayOrderId = razorpayOrderId;
		this.amount = amount;
		this.paymentStatus = paymentStatus;
	}
	

	public Payments() {
		super();
	}


	@Override
	public String toString() {
		return "Payments [paymentId=" + paymentId + ", orderId=" + orderId + ", razorpayOrderId=" + razorpayOrderId
				+ ", amount=" + amount + ", paymentStatus=" + paymentStatus + "]";
	}
	
	
}

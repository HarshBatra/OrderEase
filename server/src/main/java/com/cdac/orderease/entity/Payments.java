package com.cdac.orderease.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Payments")
public class Payments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "paymentid")
	private Long paymentId;
	
	@Column(name = "razorpayorderid")
	private String razorpayOrderId;
	
	@Column(name = "amount")
	private Double amount;
	
	@Column(name = "paymentstatus")
	private String paymentStatus;
	
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

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
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
	}

	public Payments(Long paymentId, String razorpayOrderId, Double amount, String paymentStatus, Long orderId) {
		super();
		this.paymentId = paymentId;
		this.razorpayOrderId = razorpayOrderId;
		this.amount = amount;
		this.paymentStatus = paymentStatus;
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "Payments [paymentId=" + paymentId + ", razorpayOrderId=" + razorpayOrderId + ", amount=" + amount
				+ ", paymentStatus=" + paymentStatus + ", orderId=" + orderId + "]";
	}	
	
	
}
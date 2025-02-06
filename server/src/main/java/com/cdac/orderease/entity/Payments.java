package com.cdac.orderease.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Payments")
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
	private String paymentStatus;
	
	@OneToOne
    @JoinColumn(name = "orderid", referencedColumnName = "orderid")
	@JsonIgnore
    private Order order;	
	
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
	
	public Order getOrderId() {
		return order;
	}

	public void setOrderId(Order orderId) {
		this.order = orderId;
	}

	public Payments(Long paymentId, Order orderId, String razorpayOrderId, Double amount, String paymentStatus) {
		super();
		this.paymentId = paymentId;
		this.order = orderId;
		this.razorpayOrderId = razorpayOrderId;
		this.amount = amount;
		this.paymentStatus = paymentStatus;
	}


	public Payments() {
		super();
	}


	@Override
	public String toString() {
		return "Payments [paymentId=" + paymentId + ", orderId=" + order + ", razorpayOrderId=" + razorpayOrderId
				+ ", amount=" + amount + ", paymentStatus=" + paymentStatus + "]";
	}
	
	
}

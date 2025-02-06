package com.cdac.orderease.dto;

public class PaymentsDTO {
    private Long paymentId;
    private String razorpayOrderId;
    private Double amount;
    private String paymentStatus;
    private Long orderId; // Only storing order ID instead of full Order object

    // Constructors
    public PaymentsDTO() {
    }

    public PaymentsDTO(Long paymentId, String razorpayOrderId, Double amount, String paymentStatus, Long orderId) {
        this.paymentId = paymentId;
        this.razorpayOrderId = razorpayOrderId;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
        this.orderId = orderId;
    }

    // Getters and Setters
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

	@Override
	public String toString() {
		return "PaymentsDTO [paymentId=" + paymentId + ", razorpayOrderId=" + razorpayOrderId + ", amount=" + amount
				+ ", paymentStatus=" + paymentStatus + ", orderId=" + orderId + "]";
	}
    
    
}

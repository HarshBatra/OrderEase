package com.cdac.orderease.dto;

public class PaymentsDTO {
    
    private Long paymentId;
    private Long orderId;
    private String razorpayOrderId;
    private Integer amount;
    private String paymentStatus;
    
    public PaymentsDTO() {}
    
    public PaymentsDTO(Long paymentId, Long orderId, String razorpayOrderId, Integer amount, String paymentStatus) {
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}

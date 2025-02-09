package com.cdac.orderease.mapper;

import com.cdac.orderease.dto.PaymentsDTO;
import com.cdac.orderease.entity.Payments;

public class PaymentsMapper {

    // Convert PaymentsDTO to Payments entity
//    public static Payments mapPaymentsDTOtoPayments(PaymentsDTO dto) {
//        Payments payment = new Payments();
//        payment.setPaymentId(dto.getPaymentId());
//        payment.setRazorpayOrderId(dto.getRazorpayOrderId());
//        payment.setAmount(dto.getAmount());
//        payment.setPaymentStatus(dto.getPaymentStatus());
//        // Order object will be set in the service layer, not in the mapper
//        return payment;
//    }
    
    public static Payments mapPaymentsDTOtoPayments(PaymentsDTO dto) {
        Payments payment = new Payments();
        payment.setPaymentId(dto.getPaymentId());
        payment.setRazorpayOrderId(dto.getRazorpayOrderId());
        payment.setAmount(dto.getAmount());
        payment.setPaymentStatus(dto.getPaymentStatus());
        payment.setOrderId(dto.getOrderId()); // Add this line to map the orderId
        return payment;
    }

    // Convert Payments entity to PaymentsDTO
    public static PaymentsDTO mapPaymentstoPaymentsDTO(Payments payment) {
        return new PaymentsDTO(
            payment.getPaymentId(),
            payment.getRazorpayOrderId(),
            payment.getAmount(),
            payment.getPaymentStatus(),
            payment.getOrderId()
        );
    }
}

package com.cdac.orderease.mapper;

import com.cdac.orderease.dto.PaymentsDTO;
import com.cdac.orderease.entity.Payments;

public class PaymentsMapper {
    //mapOrderDtoToOrder
//	mapPaymentsDTOtoPayments
    public static PaymentsDTO mapPaymentstoPaymentsDTO(Payments payments) {
        if (payments == null) {
            return null;
        }
        return new PaymentsDTO(
            payments.getPaymentId(),
            payments.getOrderId(),
            payments.getRazorpayOrderId(),
            payments.getAmount(),
            payments.getPaymentStatus()
        );
    }
    
    public static Payments mapPaymentsDTOtoPayments(PaymentsDTO paymentsDTO) {
        if (paymentsDTO == null) {
            return null;
        }
        Payments payments = new Payments();
        payments.setPaymentId(paymentsDTO.getPaymentId());
        payments.setOrderId(paymentsDTO.getOrderId());
        payments.setRazorpayOrderId(paymentsDTO.getRazorpayOrderId());
        payments.setAmount(paymentsDTO.getAmount());
        payments.setPaymentStatus(paymentsDTO.getPaymentStatus());
        return payments;
    }
}

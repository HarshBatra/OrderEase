package com.cdac.orderease.serviceimpl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cdac.orderease.dto.PaymentsDTO;
import com.cdac.orderease.entity.Payments;
import com.cdac.orderease.mapper.PaymentsMapper;
import com.cdac.orderease.repository.PaymentRepository;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import jakarta.annotation.PostConstruct;

@Service
public class PaymentServiceImpl {
    
    private static final Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);

    @Autowired
    private PaymentRepository paymentRepository;
    
    @Value("${razorpay.key.id}")
    private String razorpayId;

    @Value("${razorpay.key.secret}")
    private String razorpaySecret;
    
    private RazorpayClient razorpayClient;
    
    @PostConstruct
    public void init() {
        try {
            this.razorpayClient = new RazorpayClient(razorpayId, razorpaySecret);
        } catch (RazorpayException e) {
            logger.error("Error initializing Razorpay client: {}", e.getMessage());
        }
    }
    
    public PaymentsDTO createPayment(PaymentsDTO paymentDTO) {
    	System.out.println(paymentDTO);
        try {
            JSONObject options = new JSONObject();
            options.put("amount", paymentDTO.getAmount() * 100); // Convert amount to paise
            options.put("currency", "INR");
            options.put("receipt", "test@abc"); // Future scope: Replace with user email

            Order razorpayOrder = razorpayClient.orders.create(options);

            if (razorpayOrder != null) {
                Payments payment = PaymentsMapper.mapPaymentsDTOtoPayments(paymentDTO);
                System.out.println(payment);
                payment.setRazorpayOrderId(razorpayOrder.get("id"));
                payment.setPaymentStatus(razorpayOrder.get("status"));
                
                Payments savedPayment = paymentRepository.save(payment);
//                System.out.println(savedPayment);
//            	System.out.println(paymentDTO);
                return PaymentsMapper.mapPaymentstoPaymentsDTO(savedPayment);
            }
        } catch (RazorpayException e) {
            logger.error("Error creating Razorpay order: {}", e.getMessage());
        }
        return null;
    }

    public String updateStatus(Map<String, String> map) {
        String razorpayOrderId = map.get("razorpay_order_id");

        if (razorpayOrderId == null) {
            logger.error("Missing razorpay_order_id in payment callback");
            return "Invalid payment request";
        }

        Payments payment = paymentRepository.findByRazorpayOrderId(razorpayOrderId);

        if (payment == null) {
            logger.warn("Payment record not found for Razorpay Order ID: {}", razorpayOrderId);
            return "Payment record not found";
        }

        payment.setPaymentStatus("PAYMENT DONE");
        paymentRepository.save(payment);

        return "Payment status updated successfully";
    }
    
    public Optional<PaymentsDTO> findPaymentById(Long paymentId) {
        Optional<Payments> paymentOptional = paymentRepository.findById(paymentId);
        return paymentOptional.map(PaymentsMapper::mapPaymentstoPaymentsDTO);
    }

    // Method to get all payments
    public List<PaymentsDTO> getAllPayments() {
        List<Payments> payments = paymentRepository.findAll();
        return payments.stream()
                       .map(PaymentsMapper::mapPaymentstoPaymentsDTO)
                       .toList();
    }

}
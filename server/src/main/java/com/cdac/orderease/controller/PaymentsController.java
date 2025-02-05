package com.cdac.orderease.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.orderease.dto.PaymentsDTO;
import com.cdac.orderease.service.PaymentService;
import com.razorpay.RazorpayException;

@RestController
@RequestMapping("/payments")
@CrossOrigin(origins = "http://localhost:5173")  
public class PaymentsController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create")
    public ResponseEntity<?> createPayment(@RequestBody PaymentsDTO paymentsDTO) throws RazorpayException {
        PaymentsDTO createdPayment = paymentService.createPayment(paymentsDTO);
		return new ResponseEntity<>(createdPayment, HttpStatus.CREATED);
    }

    @PostMapping("/callback")
    public ResponseEntity<String> paymentCallback(@RequestParam Map<String, String> response) {
        String status = paymentService.updateStatus(response);
        return ResponseEntity.ok("Payment status updated: " + status);
    }
}

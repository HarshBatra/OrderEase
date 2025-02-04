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

import com.cdac.orderease.entity.Payments;
import com.cdac.orderease.service.PaymentService;
import com.razorpay.RazorpayException;

@RestController
@RequestMapping("/payments")  // Base URL for payments API
@CrossOrigin(origins = "http://localhost:5173")  // Allow React frontend to call this API, need to update as per frontend url
public class PaymentsController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create")
    public ResponseEntity<Payments> createPayment(@RequestBody Payments payments) throws RazorpayException {
        Payments razorpayOrder = paymentService.createPayment(payments);
        return new ResponseEntity<>(razorpayOrder, HttpStatus.CREATED);
    }

    @PostMapping("/callback")
    public ResponseEntity<String> paymentCallback(@RequestParam Map<String, String> response) {
        paymentService.updateStatus(response);
        return ResponseEntity.ok("Payment successful");
    }
}

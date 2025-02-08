package com.cdac.orderease.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.orderease.dto.PaymentsDTO;
import com.cdac.orderease.serviceimpl.PaymentServiceImpl;
import com.razorpay.RazorpayException;

@RestController
@PreAuthorize("hasRole('USER')")
@RequestMapping("/payments")
@CrossOrigin(origins = "http://localhost:5173")  
public class PaymentsController {

    @Autowired
    private PaymentServiceImpl paymentService;

    @PostMapping("/create")
    public ResponseEntity<?> createPayment(@RequestBody PaymentsDTO paymentsDTO) throws RazorpayException {
        PaymentsDTO createdPayment = paymentService.createPayment(paymentsDTO);
        System.out.println(createdPayment);
		return new ResponseEntity<>(createdPayment, HttpStatus.CREATED);
    }

    @PostMapping("/callback")
    public ResponseEntity<String> paymentCallback(@RequestParam Map<String, String> response) {
        String status = paymentService.updateStatus(response);
        return ResponseEntity.ok("Payment status updated: " + status);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<PaymentsDTO> getPaymentById(@PathVariable("id") Long id) {
        Optional<PaymentsDTO> paymentDTO = paymentService.findPaymentById(id);
        return paymentDTO.map(ResponseEntity::ok)
                         .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping
    public ResponseEntity<List<PaymentsDTO>> getAllPayments() {
        List<PaymentsDTO> payments = paymentService.getAllPayments();
        return ResponseEntity.ok(payments);
    }
}

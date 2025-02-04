package com.cdac.orderease.service;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cdac.orderease.entity.Payments;
import com.cdac.orderease.repository.PaymentRepository;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import jakarta.annotation.PostConstruct;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Value("${razorpay.key.id}")
	private String razorpayId;
	@Value("${razorpay.key.secret}")
	private String razorpaySecret;
	
	private RazorpayClient razorpayCLient;
	
	@PostConstruct
	public void init() throws RazorpayException {
		this.razorpayCLient = new RazorpayClient(razorpayId, razorpaySecret);
	}
	
	public Payments createPayment(Payments payment) throws RazorpayException {
        JSONObject options = new JSONObject();
        options.put("amount", payment.getAmount() * 100); // amount in paise
        options.put("currency", "INR");
        options.put("receipt", "test@abc");//need to add user email as recipt future scope
        Order razorpayOrder = razorpayCLient.orders.create(options);
        if(razorpayOrder != null) {
        	payment.setRazorpayOrderId(razorpayOrder.get("id"));
        	payment.setPaymentStatus(razorpayOrder.get("status"));
        }
        return paymentRepository.save(payment);
    }

	public Payments updateStatus(Map<String, String> map) {
    	String razorpayId = map.get("razorpay_order_id");
    	Payments payment = paymentRepository.findByRazorpayOrderId(razorpayId);
    	payment.setPaymentStatus("PAYMENT DONE");
    	Payments payments = paymentRepository.save(payment);
    	return payments;
    }
}

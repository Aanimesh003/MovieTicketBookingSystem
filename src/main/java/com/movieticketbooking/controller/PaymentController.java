package com.movieticketbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movieticketbooking.entity.Payment;
import com.movieticketbooking.entity.User;
import com.movieticketbooking.service.PaymentService;

@RestController
public class PaymentController {

	@Autowired
	private PaymentService ps;

	@GetMapping("/allPayments")
	public List<Payment> getAllPaymentDetails() {
		return ps.getAllPaymentDetails();
	}

	@GetMapping("/payment/{id}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable int id) {
		Payment payment = ps.getPaymentById(id);
		if (payment == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(payment);
		}
	}

	@PostMapping("/savePayment")
	public String savePayment(@RequestBody Payment payment) {
		return ps.savePayment(payment);
	}

	@DeleteMapping("/delete/{id}/payment")
	public String deletePayment(@PathVariable int id) {
		return ps.deletePayment(id);
	}

	@GetMapping("/userid/{id}/payment")
	public List<Payment> getPaymentByUserId(@PathVariable int id) {
		return ps.getPaymentByUserId(id);
	}

	@GetMapping("paymentid/{id}/user")
	public User getUserByPaymentid(@PathVariable int id) {
		return ps.getUserByPaymentid(id);
	}

	@GetMapping("/success-payments")
	public List<Payment> getAllSuccessPaymentStatus() {
		return ps.getAllSuccessPaymentStatus();
	}

	@GetMapping("/pending-payments")
	public List<Payment> getAllPendingPaymentStatus() {
		return ps.getAllPendingPaymentStatus();
	}

	@GetMapping("/failed-payments")
	public List<Payment> getAllFailedPaymentStatus() {
		return ps.getAllFailedPaymentStatus();
	}

}

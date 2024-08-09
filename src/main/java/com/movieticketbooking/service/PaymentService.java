package com.movieticketbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieticketbooking.dao.PaymentDao;
import com.movieticketbooking.entity.Payment;
import com.movieticketbooking.entity.User;

@Service
public class PaymentService {

	@Autowired
	private PaymentDao pd;
	
	public List<Payment> getAllPaymentDetails() {
		return pd.getAllPaymentDetails();
	}

	public Payment getPaymentById(int id) {
		return pd.getPaymentById(id);
	}

	public String savePayment(Payment payment) {
		return pd.savePayment(payment);
	}

	public String deletePayment(int id) {
		return pd.deletePayment(id);
	}

	public List<Payment> getPaymentByUserId(int id) {
		return pd.getPaymentByUserId(id);
	}

	public User getUserByPaymentid(int id) {
		return pd.getUserByPaymentid(id);
	}

	public List<Payment> getAllSuccessPaymentStatus() {
		return pd.getAllSuccessPaymentStatus();
	}

	public List<Payment> getAllPendingPaymentStatus() {
		return pd.getAllPendingPaymentStatus();
	}

	public List<Payment> getAllFailedPaymentStatus() {
		return pd.getAllFailedPaymentStatus();
	}

}

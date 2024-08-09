package com.movieticketbooking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Payment {

	@Id
	private int id;
	private String cardNumber;
	private double amount;
	private String status;
	
	@ManyToOne
	@JoinColumn(name="userid")
	@JsonIgnore
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Payment(int id, String cardNumber, double amount, String status, User user) {
		super();
		this.id = id;
		this.cardNumber = cardNumber;
		this.amount = amount;
		this.status = status;
		this.user = user;
	}

	public Payment() {
		super();
	}
	
}

package com.movieticketbooking.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movieticketbooking.entity.Payment;
import com.movieticketbooking.entity.User;

@Repository
public class PaymentDao {

	@Autowired
	private SessionFactory sf;

	public List<Payment> getAllPaymentDetails() {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria crt = session.createCriteria(Payment.class);
		List<Payment> payment = crt.list();
		tr.commit();
		return payment;
	}

	public Payment getPaymentById(int id) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria crt = session.createCriteria(Payment.class);
		Payment payment = session.get(Payment.class, id);
		tr.commit();
		return payment;
	}

	public String savePayment(Payment payment) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria crt = session.createCriteria(Payment.class);
		session.save(payment);
		tr.commit();
		return "Payment saved successfully";
	}

	public String deletePayment(int id) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria crt = session.createCriteria(Payment.class);
		Payment payment = session.get(Payment.class, id);
		try {
			session.delete(payment);
			tr.commit();
			return "payment deleted successfully";
		} catch (Exception e) {
			return "payment of this id is not present, please enter again";
		}
	}

	public List<Payment> getPaymentByUserId(int id) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria crt = session.createCriteria(Payment.class);
		crt.createAlias("user", "u");
		crt.add(Restrictions.eq("u.id", id));
		List<Payment> payment = crt.list();
		tr.commit();
		return payment;
	}

	public User getUserByPaymentid(int id) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria crt = session.createCriteria(Payment.class);
		crt.add(Restrictions.eq("id", id));
		crt.setProjection(Projections.property("user"));
		User user=(User) crt.uniqueResult();
		tr.commit();
		return user;
	}

	public List<Payment> getAllSuccessPaymentStatus() {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria crt = session.createCriteria(Payment.class);
		crt.add(Restrictions.eq("status", "success"));
		List<Payment> payment=crt.list();
		tr.commit();
		return payment;
	}

	public List<Payment> getAllPendingPaymentStatus() {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria crt = session.createCriteria(Payment.class);
		crt.add(Restrictions.eq("status", "pending"));
		List<Payment> payment=crt.list();
		tr.commit();
		return payment;
	}

	public List<Payment> getAllFailedPaymentStatus() {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria crt = session.createCriteria(Payment.class);
		crt.add(Restrictions.eq("status", "failed"));
		List<Payment> payment=crt.list();
		tr.commit();
		return payment;
	}

}

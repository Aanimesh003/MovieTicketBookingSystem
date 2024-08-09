package com.movieticketbooking.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movieticketbooking.entity.Seat;

@Repository
public class SeatDao {

	@Autowired
	private SessionFactory sf;
	
	public List<Seat> getAllSeats() {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Criteria crt=session.createCriteria(Seat.class);
		List<Seat> seat=crt.list();
		tr.commit();
		return seat;
	}

	public Seat getSeatByid(int id) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Criteria crt=session.createCriteria(Seat.class);
		Seat seat=session.get(Seat.class, id);
		tr.commit();
		return seat;
	}
	
	public String saveSeat(Seat seat) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Criteria crt=session.createCriteria(Seat.class);
		session.save(seat);
		tr.commit();
		return "seat saved successfully";
	}

	public String updateSeatNo(int id,int seatNo) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Criteria crt=session.createCriteria(Seat.class);
		try {
			crt.add(Restrictions.eq("seatid", id));
			Seat seat=(Seat) crt.uniqueResult();
			seat.setSeatno(seatNo);
			session.update(seat);
			tr.commit();
			return "seatNo updated successfully";
		}
		catch (Exception e) {
			return "Seat id is not present, please try again";

		}
	}

	public String deleteMapping(int id) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Criteria crt=session.createCriteria(Seat.class);
		Seat seat=session.get(Seat.class, id);
		try {
			session.delete(seat);
			tr.commit();
			return "Deleted successfully";
		}
		catch (Exception e) {
			return "Seat is is not present, please try again";
		}
	}


}

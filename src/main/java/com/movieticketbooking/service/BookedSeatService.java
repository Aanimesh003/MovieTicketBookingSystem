package com.movieticketbooking.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieticketbooking.dao.BookedSeatDao;
import com.movieticketbooking.entity.BookedSeat;
import com.movieticketbooking.entity.Screening;
import com.movieticketbooking.entity.Seat;

@Service
public class BookedSeatService {

	@Autowired
	private BookedSeatDao bsd;

	public List<BookedSeat> getAllBookedSeat() {
		return bsd.getAllBookedSeat();
	}

	public BookedSeat getBookedSeatById(int id) {
		return bsd.getBookedSeatById(id);
	}

	public String updateBookedSeat(BookedSeat bookedSeat) {
		return bsd.updateBookedSeat(bookedSeat);
	}

	public List<Integer> getBookedSeatBySeatid(int id) {
		return bsd.getBookedSeatBySeatid(id);
	}

	public Seat getSeatByBookedseatId(int id) {
		return bsd.getSeatByBookedseatId(id);
	}

	public Screening getScreeningByBookedseatId(int id) {
		return bsd.getScreeningByBookedseatId(id);
	}

}

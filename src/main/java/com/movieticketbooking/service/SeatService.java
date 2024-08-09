package com.movieticketbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieticketbooking.dao.SeatDao;
import com.movieticketbooking.entity.Seat;

@Service
public class SeatService {

	@Autowired
	private SeatDao sd;
	
	public List<Seat> getAllSeats() {
		return sd.getAllSeats();
	}

	public Seat getSeatByid(int id) {
		return sd.getSeatByid(id);
	}
	
	public String saveSeat(Seat seat) {
		return sd.saveSeat(seat);
	}

	public String updateSeatNo(int id,int seatNo) {
		return sd.updateSeatNo(id,seatNo);
	}

	public String deleteMapping(int id) {
		return sd.deleteMapping(id);
	}

}


package com.movieticketbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movieticketbooking.entity.BookedSeat;
import com.movieticketbooking.entity.Screening;
import com.movieticketbooking.entity.Seat;
import com.movieticketbooking.service.BookedSeatService;

@RestController
public class BookedSeatController {

	@Autowired
	private BookedSeatService bs;

	@GetMapping("/allBookedSeat")
	public List<BookedSeat> getAllBookedSeat() {
		return bs.getAllBookedSeat();
	}

	@GetMapping("/{id}/bookedSeat")
	public BookedSeat getBookedSeatById(@PathVariable int id) {
		return bs.getBookedSeatById(id);
	}

	@PutMapping("{id}/update-bookedSeat")
	public String updateBookedSeat(@PathVariable int id, @RequestBody BookedSeat bookedSeat) {
		bookedSeat.setBookedseatid(id);
		return bs.updateBookedSeat(bookedSeat);
	}

	@GetMapping("seatid/{id}/bookedseatid")
	public List<Integer> getBookedSeatBySeatid(@PathVariable int id) {
		return bs.getBookedSeatBySeatid(id);
	}

	@GetMapping("/bookedseat/{id}/seat")
	public Seat getSeatByBookedseatId(@PathVariable int id) {
		return bs.getSeatByBookedseatId(id);
	}

	@GetMapping("/bookedseat/{id}/screening")
	public Screening getScreeningByBookedseatId(@PathVariable int id) {
		return bs.getScreeningByBookedseatId(id);
	}
}

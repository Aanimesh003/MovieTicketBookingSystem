package com.movieticketbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movieticketbooking.entity.Seat;
import com.movieticketbooking.service.SeatService;

@RestController
public class SeatController {

	@Autowired
	private SeatService ss;

	@GetMapping("/allSeats")
	public List<Seat> getAllSeats() {
		return ss.getAllSeats();
	}

	@GetMapping("{id}/seat")
	public Seat getSeatByid(@PathVariable int id) {
		return ss.getSeatByid(id);
	}

	@PostMapping("/saveSeat")
	public String saveSeat(@RequestBody Seat seat) {
		return ss.saveSeat(seat);
	}

	@PutMapping("/{id}/updateSeat")
	public String updateSeatNo(@PathVariable int id, @RequestParam("seatNo") int seatNo) {
		return ss.updateSeatNo(id, seatNo);
	}

	@DeleteMapping("/delete-seat/{id}")
	public String deleteMapping(@PathVariable int id) {
		return ss.deleteMapping(id);
	}
}

package com.movieticketbooking.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class BookedSeat {
 
	@Id
	private int bookedseatid;
	
	@ManyToOne
	@JoinColumn(name="seatid")
	private Seat seat;
	
	@ManyToOne
	@JoinColumn(name="screeningid")
	private Screening screening;

	public int getBookedseatid() {
		return bookedseatid;
	}

	public void setBookedseatid(int bookedseatid) {
		this.bookedseatid = bookedseatid;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public Screening getScreening() {
		return screening;
	}

	public void setScreening(Screening screening) {
		this.screening = screening;
	}

	public BookedSeat(int bookedseatid, Seat seat, Screening screening) {
		super();
		this.bookedseatid = bookedseatid;
		this.seat = seat;
		this.screening = screening;
	}

	public BookedSeat() {
		super();
	}
	
}

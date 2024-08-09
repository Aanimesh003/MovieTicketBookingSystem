package com.movieticketbooking.entity;

import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Screening {

	@Id
	private int screeningid;
	
	@ManyToOne
    @JoinColumn(name = "movieid")
	private Movie movie;
	
	private LocalDate date;
	private double price;
	
	@OneToMany(mappedBy = "screening")
	@JsonIgnore
	private Set<BookedSeat> bookedseat;
	
	
	public int getScreeningid() {
		return screeningid;
	}
	public void setScreeningid(int screeningid) {
		this.screeningid = screeningid;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Set<BookedSeat> getBookedseat() {
		return bookedseat;
	}
	public void setBookedseat(Set<BookedSeat> bookedseat) {
		this.bookedseat = bookedseat;
	}
	
	public Screening(int screeningid, Movie movie, LocalDate date, double price,Set<BookedSeat> bookedseat) {
		super();
		this.screeningid = screeningid;
		this.movie = movie;
		this.date = date;
		this.price = price;
		this.bookedseat=bookedseat;
	}
	
	public Screening() {
		super();
	}

	
}

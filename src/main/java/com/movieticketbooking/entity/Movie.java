package com.movieticketbooking.entity;

import java.time.LocalTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Movie {

	@Id
	private int movieid;
	private String title;
	private LocalTime duration;
	private String leadactor_name;
	private float rating;
	private String category;
	private String theater;
	
	@OneToMany(mappedBy = "movie")
	@JsonIgnore
	private Set<Screening> screening;
	
	public int getMovieid() {
		return movieid;
	}
	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalTime getDuration() {
		return duration;
	}
	public void setDuration(LocalTime duration) {
		this.duration = duration;
	}
	public String getLeadactor_name() {
		return leadactor_name;
	}
	public void setLeadactor_name(String leadactor_name) {
		this.leadactor_name = leadactor_name;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTheater() {
		return theater;
	}
	public void setTheater(String theater) {
		this.theater = theater;
	}
	public Set<Screening> getScreening() {
		return screening;
	}
	public void setScreening(Set<Screening> screening) {
		this.screening = screening;
	}
	
	public Movie(int movieid, String title, LocalTime duration, String leadactor_name, float rating, String category,
			String theater, Set<Screening> screening) {
		super();
		this.movieid = movieid;
		this.title = title;
		this.duration = duration;
		this.leadactor_name = leadactor_name;
		this.rating = rating;
		this.category = category;
		this.theater = theater;
		this.screening=screening;
	}
	
	public Movie() {
		super();
	}
	
}

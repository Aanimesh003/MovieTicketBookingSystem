package com.movieticketbooking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieticketbooking.dao.MovieDao;
import com.movieticketbooking.entity.Movie;

@Service
public class MovieService {

	@Autowired
	private MovieDao md;
	
	public Movie getMoviebyId(int id) {
		return md.getMoviebyId(id);
	}
	
	public String saveMovie(Movie movie) {
		return md.saveMovie(movie);
	}

	public String updateMovie(Movie movie) {
		return md.updateMovie(movie);
	}

	public String deleteMovie(int id) {
		return md.deleteMovie(id);
	}

	public String mergeMovie(Movie movie) {
		return md.mergeMovie(movie);
	}

	public List<Movie> getAllMovie() {
		return md.getAllMovie();
	}

	public List<Movie> getAnimationMovie() {
		return md.getAnimationMovie();
	}

	public List<Movie> getHorrorAndTrillerMovie() {
		List<Movie>movie=md.getHorrorAndTrillerMovie();
		 return movie;
	}

	public List<Movie> getRatingGT4() {
		List<Movie> movie=md.getRatingGT4();
		
		List<Movie> al=new ArrayList<>();
		for(Movie m : movie)
		{
			if(m.getRating() >4.0)
			{
				al.add(m);
			}
		}
		return al;
		}

	public List<Movie> getRatingLT4() {
		List<Movie> movie=md.getRatingLT4();
		
		List<Movie> al=new ArrayList<>();
		for(Movie m : movie)
		{
			if(m.getRating() <4.0)
			{
				al.add(m);
			}
		}
		return al;
	}

	public List<String> getMovieName() {
		return md.getMovieName();
	}

	public List<Movie> getApolloTheaterName() {
		return md.getApolloTheaterName();
	}

	public List<Movie> getCinemaHallsinPuneTheaterName() {
		return md.getCinemaHallsinPuneTheaterName();
	}

	public List<Movie> getCityPrideTheaterName() {
		return md.getCityPrideTheaterName();
	}

	public List<Movie> getRahul70MMTheaterName() {
		return md.getRahul70MMTheaterName();
	}

	public List<Movie> getSatyamMinitheaterTheaterName() {
		return md.getSatyamMinitheaterTheaterName();
	}

	public List<Movie> getCityPridetheaterMovies() {
		return md.getCityPridetheaterMovies();
		
	}

	public List<String> getCityPridetheaterMoviename() {
		return md.getCityPridetheaterMoviename();
	}

	public List<Movie> getCinemaHallsinPunetheaterMovies() {
		return md.getCinemaHallsinPunetheaterMovies();
	}

	public List<String> getCinemaHallsinPunetheaterMoviename() {
		return md.getCinemaHallsinPunetheaterMoviename();
	}

	public List<Movie> getSatyamMinitheaterMovies() {
		return md.getSatyamMinitheaterMovies();
	}

	public List<String> getSatyamMinietheaterMoviename() {
		return md.getSatyamMinietheaterMoviename();
	}

	public List<Movie> getRahul70MMtheaterMovies() {
		return md.getRahul70MMtheaterMovies();
				}

	public List<String> getRahul70MMtheaterMoviename() {
		return md.getRahul70MMtheaterMoviename();
	}

	public List<Movie> getApollotheaterMovies() {
		return md.getApollotheaterMovies();
	}

	public List<String> getApollotheaterMoviename() {
		return md.getApollotheaterMoviename();
	}
	}


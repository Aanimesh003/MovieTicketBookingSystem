package com.movieticketbooking.service;

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
}


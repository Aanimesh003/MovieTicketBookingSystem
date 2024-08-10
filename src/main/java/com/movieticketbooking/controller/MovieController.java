package com.movieticketbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movieticketbooking.entity.Movie;
import com.movieticketbooking.service.MovieService;

@RestController
public class MovieController {

	@Autowired
	private MovieService ms;

	@GetMapping("movie/{id}")
	public ResponseEntity<Movie> getMoviebyId(@PathVariable int id) {
		Movie movie = ms.getMoviebyId(id);
		if (movie == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(movie);
		}
	}

	@PostMapping("/savemovie")
	public String saveMovie(@RequestBody Movie movie) {
		return ms.saveMovie(movie);
	}

	@PutMapping("/{id}")
	public String updateMovie(@PathVariable int id, @RequestBody Movie movie) {
		movie.setMovieid(id);
		return ms.updateMovie(movie);
	}

	@DeleteMapping("movie/{id}")
	public String deleteMovie(@PathVariable("id") int id) {
		return ms.deleteMovie(id);
	}

	@PutMapping("merge/{id}")
	public String mergeMovie(@PathVariable int id, @RequestBody Movie movie) {
		movie.setMovieid(id);
		return ms.mergeMovie(movie);
	}

	@GetMapping("/allmovie")
	public List<Movie> getAllMovie() {
		return ms.getAllMovie();
	}

	@GetMapping("animationmovie")
	public List<Movie> getAnimationMovie() {
		return ms.getAnimationMovie();
	}

	@GetMapping("horror/triller")
	public List<Movie> getHorrorAndTrillerMovie() {
		return ms.getHorrorAndTrillerMovie();
	}

	@GetMapping("rating4")
	public List<Movie> getRatingGT4() {
		return ms.getRatingGT4();
	}

	@GetMapping("ratinglessthan4")
	public List<Movie> getRatingLT4() {
		return ms.getRatingLT4();
	}

	@GetMapping("/moviename")
	public List<String> getMovieName() {
		return ms.getMovieName();
	}
}
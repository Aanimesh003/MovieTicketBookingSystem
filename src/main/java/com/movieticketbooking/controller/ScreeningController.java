package com.movieticketbooking.controller;

import java.sql.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movieticketbooking.entity.Movie;
import com.movieticketbooking.entity.Screening;
import com.movieticketbooking.service.ScreeningService;

@RestController
public class ScreeningController {

	@Autowired
	private ScreeningService ss;

	@GetMapping("/allScreening")
	public List<Screening> getAllScreening() {
		return ss.getAllScreening();
	}

	@GetMapping("/screening/{id}")
	public ResponseEntity<Object> getScreeningByid(@PathVariable int id) {
		Screening screen = ss.getScreeningByid(id);
		if (screen == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(screen);
		}
	}

	@PostMapping("/savescreening")
	public String saveScreening(@RequestBody Screening screen) {
		return ss.saveScreening(screen);
	}

	@PutMapping("/screening/{id}")
	public String updateScreening(@PathVariable int id, @RequestBody Screening screen) {
		screen.setScreeningid(id);
		return ss.updateScreening(screen);
	}

	@DeleteMapping("/screening/{id}")
	public String deleteScreening(@PathVariable int id) {
		return ss.deleteScreening(id);
	}

	@GetMapping("/screening/{id}/movieid")
	public List<Integer> getMovieIdByScreeningId(@PathVariable int id) {
		return ss.getMovieIdByScreeningId(id);
	}

	@GetMapping("/screening/{id}/movie")
	public Movie getMovieByScreeningid(@PathVariable int id) {
		return ss.getMovieByScreeningid(id);
	}

	@GetMapping("/moiveid/{id}/screeningid")
	public List<Integer> getScreeningidByMovieId(@PathVariable int id) {
		return ss.getScreeningidByMovieId(id);
	}

	@GetMapping("/moiveid/{id}/screening")
	public List<Screening> getScreeningByMovieId(@PathVariable int id) {
		return ss.getScreeningByMovieId(id);
	}

	@GetMapping("/price/{id}")
	public List<Double> getPriceByMovieid(@PathVariable int id) {
		return ss.getPriceByMovieid(id);
	}

	@GetMapping("/{id}/movieName/price")
	public Object[] getMovienameAndPriceByScreenid(@PathVariable int id) {
		return ss.getMovienameAndPriceByScreenid(id);
	}

	@GetMapping("/sumOfprice")
	public Double getTotalPrice() {
		return ss.getTotalPrice();
	}

	@GetMapping("/avgOfprice")
	public Double getAverageofPrice() {
		return ss.getAverageofPrice();
	}

	@GetMapping("/alldates")
	public List<Date> getAllDates() {
		return ss.getAllDates();
	}

	@GetMapping("screeningid/{id}/date")
	public List<Date> getDatebyScreeningid(@PathVariable int id) {
		return ss.getDatebyScreeningid(id);
	}

	@GetMapping("/maxPrice")
	public Double getMaxPrice() {
		return ss.getMaxPrice();
	}

	@GetMapping("/screening/rowCount")
	public Long getCountofRows() {
		return ss.getCountofRows();
	}

	@GetMapping("/screeningid/{id}/price")
	public List<Double> getPriceByScreeningid(@PathVariable int id) {
		return ss.getPriceByScreeningid(id);
	}

	@PutMapping("/screening/{id}/updatePrice")
	public String updatePriceofScreeningid(@PathVariable int id, @RequestParam("price") Double updatedprice) {
		return ss.updatePriceofScreeningid(id, updatedprice);
	}

	@PutMapping("/screening/{id}/updateDate")
	public String updateDateofScreeningid(@PathVariable int id,
			@RequestParam @DateTimeFormat(pattern = "yyyy-M-d") LocalDate date) {
		return ss.updateDateofScreeningid(id, date);
	}

	@GetMapping("/movie-by-date")
	public Map<String, Object> getmovieIdandMovieNameByDate(
			@RequestParam("date") @DateTimeFormat(pattern = "yyyy-M-d") LocalDate date) {
		return ss.getmovieIdandMovieNameByDate(date);
	}

	@GetMapping("/date/{id}/movieId-by")
	public List<LocalDate> getDateBymovieId(@PathVariable int id) {
		List<LocalDate> dates = ss.getDateBymovieId(id);
		return dates;
	}

	@GetMapping("/date-between")
	public ResponseEntity<List<Screening>> getDateBetween(
			@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") String startDate,
			@RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") String endDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat();
		Date Startdate;
		try {
			Startdate = (Date) dateFormat.parse(startDate);
			Date Enddate = (Date) dateFormat.parse(endDate);
			List<Screening> screen = ss.getDateBetween(Startdate, Enddate);
			return ResponseEntity.ok(screen);
		} catch (ParseException e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping("/movieid-between-screeningid")
	public ResponseEntity<Object> getMovieBetweenScreeningid(@RequestParam("start-screeningid") int startId,
			@RequestParam("end-screeningid") int endId) {
		List<Integer> movieid = ss.getMovieBetweenScreeningid(startId, endId);

		if (movieid.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(movieid);
		}
	}
}

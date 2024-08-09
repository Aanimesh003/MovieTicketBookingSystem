package com.movieticketbooking.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieticketbooking.dao.ScreeningDao;
import com.movieticketbooking.entity.Movie;
import com.movieticketbooking.entity.Screening;

@Service
public class ScreeningService {

	@Autowired
	private ScreeningDao sd;
	
	public List<Screening> getAllScreening() {
		return sd.getAllScreening();
	}

	public Screening getScreeningByid(int id) {
		return sd.getScreeningByid(id);
	}

	public String saveScreening(Screening screen) {
		return sd.saveScreening(screen);
		}

	public String updateScreening(Screening screen) {
		return sd.updateScreening(screen);
	}

	public String deleteScreening(int id) {
		return sd.deleteScreening(id);
	}

	public List<Integer> getMovieIdByScreeningId(int id) {
		return sd.getMovieIdByScreeningId(id);
	}

	public Movie getMovieByScreeningid(int id) {
		return sd.getMovieByScreeningid(id);
	}

	public List<Integer> getScreeningidByMovieId(int id) {
		return sd.getScreeningidByMovieId(id);
	}

	public List<Screening> getScreeningByMovieId(int id) {
		return sd.getScreeningByMovieId(id);
	}

	public List<Double> getPriceByMovieid(int id) {
		return sd.getPriceByMovieid(id);
	}

	public Object[] getMovienameAndPriceByScreenid(int id) {
		return sd.getMovienameAndPriceByScreenid(id);
	}

	public Double getTotalPrice() {
		return sd.getTotalPrice();
	}
	
	public Double getAverageofPrice() {
		return sd.getAverageofPrice();
	}
	
	public List<Date> getAllDates() {
		return sd.getAllDates();
	}

	public List<Date> getDatebyScreeningid(int id) {
		return sd.getDatebyScreeningid(id);
	}

	public Double getMaxPrice() {
		return sd.getMaxPrice();
	}

	public Long getCountofRows() {
		return sd.getCountofRows();
	}

	public List<Double> getPriceByScreeningid(int id) {
		return sd.getPriceByScreeningid(id);
	}

	 public String updatePriceofScreeningid(int id, double price) {
		return sd.updatePriceofScreeningid(id, price);
	}

	public String updateDateofScreeningid(int id, LocalDate date) {
		return sd.updateDateofScreeningid(id,date);
		}

	public Map<String, Object> getmovieIdandMovieNameByDate(LocalDate date) {
		 List<Object[]> result=sd.getmovieIdandMovieNameByDate(date);
		 Map<String, Object> hm=new HashMap<>();
		 for(Object[] rs :result)
		 {
			 Integer id=(Integer) rs[0];
			 String title=(String) rs[1];
			 hm.put("id: "+id, ",movieTital: "+title);
		 }
		 return hm;
	}

	public List<LocalDate> getDateBymovieId(int id) 
	{
		 List<LocalDate> dates=sd.getDateBymovieId(id);
		 if(dates.isEmpty())
		 {
			 if (dates.isEmpty()) {
		            throw new IllegalArgumentException("Movie id " + id + " not found");
		        }
		 }
		 return dates;
	}

	public List<Screening> getDateBetween(Date startDate, Date endDate) {
		return sd.getDateBetween(startDate,endDate);
	}

	public List<Integer> getMovieBetweenScreeningid(int startId, int endId) {
		return sd.getMovieBetweenScreeningid(startId,endId);
	}

	



	

}

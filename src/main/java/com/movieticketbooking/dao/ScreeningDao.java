package com.movieticketbooking.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movieticketbooking.entity.Movie;
import com.movieticketbooking.entity.Screening;
import com.movieticketbooking.entity.User;

@Repository
public class ScreeningDao {

	@Autowired
	private SessionFactory sf;

	public List<Screening> getAllScreening() {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria crt = session.createCriteria(Screening.class);
		List<Screening> screen = crt.list();
		tr.commit();
		return screen;
	}

	public Screening getScreeningByid(int id) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria crt = session.createCriteria(Screening.class);
		Screening screen = session.get(Screening.class, id);
		tr.commit();
		return screen;
	}

	public String saveScreening(Screening screen) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria crt = session.createCriteria(Screening.class);
		session.save(screen);
		tr.commit();
		return "Saved successfully";
	}

	public String updateScreening(Screening screen) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria crt = session.createCriteria(Screening.class);
		try {
			session.update(screen);
			tr.commit();
			return "Updated successfully";
		} catch (Exception e) {
			return "Screening of this id is not present, please enter again";
		}
	}

	public String deleteScreening(int id) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria crt = session.createCriteria(Screening.class);
		Screening screen = session.get(Screening.class, id);
		try {
			session.delete(screen);
			tr.commit();
			return "Deleted successfully";
		} catch (Exception e) {
			return "Screening of this id is not present, please enter again";
		}
	}

	public List<Integer> getMovieIdByScreeningId(int id) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria crt = session.createCriteria(Screening.class);
		crt.createAlias("movie", "m");
		crt.add(Restrictions.eq("screeningid", id));
		crt.setProjection(Projections.property("m.id"));
		List<Integer> movieid = crt.list();
		tr.commit();
		return movieid;
	}

	public Movie getMovieByScreeningid(int id) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria crt = session.createCriteria(Screening.class);
		crt.add(Restrictions.eq("screeningid", id));
		crt.setProjection(Projections.property("movie"));
		Movie movie = (Movie) crt.uniqueResult();
		tr.commit();
		return movie;
	}

	public List<Integer> getScreeningidByMovieId(int id) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria crt = session.createCriteria(Screening.class);
		crt.add(Restrictions.eq("movie.movieid", id));
		crt.setProjection(Projections.property("screeningid"));
		List<Integer> screeningid = crt.list();
		tr.commit();
		return screeningid;
	}

	public List<Screening> getScreeningByMovieId(int id) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria crt = session.createCriteria(Screening.class);
		crt.add(Restrictions.eq("movie.movieid", id));
		List<Screening> screen = crt.list();
		tr.commit();
		return screen;
	}

	public List<Double> getPriceByMovieid(int id) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria crt = session.createCriteria(Screening.class);
		crt.add(Restrictions.eq("movie.movieid", id));
		crt.setProjection(Projections.property("price"));
		List<Double> price = crt.list();
		tr.commit();
		return price;
	}

	public Object[] getMovienameAndPriceByScreenid(int id) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria crt = session.createCriteria(Screening.class);
		crt.createAlias("movie", "m");
		crt.add(Restrictions.eq("screeningid", id));
		crt.setProjection(
				Projections.projectionList().add(Projections.property("m.title")).add(Projections.property("price")));
		Object[] result = (Object[]) crt.uniqueResult();
		return result;
	}

	public Double getTotalPrice() {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria crt = session.createCriteria(Screening.class);
		crt.setProjection(Projections.sum("price"));
		Double totalprice = (Double) crt.uniqueResult();
		tr.commit();
		return totalprice;
	}

	public Double getAverageofPrice() {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria crt = session.createCriteria(Screening.class);
		crt.setProjection(Projections.avg("price"));
		Double average = (Double) crt.uniqueResult();
		tr.commit();
		return average;
	}

	public List<Date> getAllDates() {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria crt = session.createCriteria(Screening.class);
		crt.setProjection(Projections.property("date"));
		List<Date> dates = crt.list();
		tr.commit();
		return dates;
	}

	public List<Date> getDatebyScreeningid(int id) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria crt = session.createCriteria(Screening.class);
		crt.add(Restrictions.eq("screeningid", id));
		crt.setProjection(Projections.property("date"));
		List<Date> date = crt.list();
		return date;
	}

	public Double getMaxPrice() {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria crt = session.createCriteria(Screening.class);
		crt.setProjection(Projections.max("price"));
		Double maxPrice = (Double) crt.uniqueResult();
		tr.commit();
		return maxPrice;
	}

	public Long getCountofRows() {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria crt = session.createCriteria(Screening.class);
		crt.setProjection(Projections.rowCount());
		Long count = (Long) crt.uniqueResult();
		return count;
	}

	public List<Double> getPriceByScreeningid(int id) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria crt = session.createCriteria(Screening.class);
		crt.add(Restrictions.eq("screeningid", id));
		crt.setProjection(Projections.property("price"));
		List<Double> price = crt.list();
		tr.commit();
		return price;
	}

	public String updatePriceofScreeningid(int id, double price) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria crt = session.createCriteria(Screening.class);
		try {
			crt.add(Restrictions.eq("screeningid", id));
			Screening screen = (Screening) crt.uniqueResult();
			screen.setPrice(price);
			session.update(screen);
			tr.commit();
			return "price updated";
		} catch (Exception e) {
			return "screening of this id is not present, please try again";
		}
	}

	public String updateDateofScreeningid(int id, LocalDate date) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria crt = session.createCriteria(Screening.class);
		try {
			crt.add(Restrictions.eq("screeningid", id));
			Screening screen = (Screening) crt.uniqueResult();
			screen.setDate(date);
			tr.commit();
			return "Date updated";
		} catch (Exception e) {
			return "screening of this id is not present, please try again";
		}
	}

	public List<Object[]> getmovieIdandMovieNameByDate(LocalDate date) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria crt = session.createCriteria(Screening.class);
		crt.add(Restrictions.eq("date", date));
		crt.createAlias("movie", "m");
		crt.setProjection(
				Projections.projectionList().add(Projections.property("m.id")).add(Projections.property("m.title")));
		List<Object[]> result = crt.list();
		tr.commit();
		return result;
	}

	public List<LocalDate> getDateBymovieId(int id) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria crt = session.createCriteria(Screening.class);
		crt.add(Restrictions.eq("movie.movieid", id));
		crt.setProjection(Projections.distinct(Projections.property("date")));
		List<LocalDate> dates = crt.list();
		tr.commit();
		return dates;
	}

	public List<Screening> getDateBetween(Date startDate, Date endDate) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria crt = session.createCriteria(Screening.class);
		crt.add(Restrictions.between("date", startDate, endDate));
		List<Screening> screen=crt.list();
		tr.commit();
		return screen;
	}

	public List<Integer> getMovieBetweenScreeningid(int startId, int endId) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria crt = session.createCriteria(Screening.class);
		crt.add(Restrictions.between("screeningid", startId, endId));
		crt.setProjection(Projections.distinct(Projections.property("movie")));
		List<Integer> movieId=crt.list();
		return movieId;
	}

	

}

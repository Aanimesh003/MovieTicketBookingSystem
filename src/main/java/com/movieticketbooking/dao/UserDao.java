package com.movieticketbooking.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movieticketbooking.entity.Movie;
import com.movieticketbooking.entity.User;

@Repository
public class UserDao {

	@Autowired
	private SessionFactory sf;

	public List<User> getAllUser() {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria crt = session.createCriteria(User.class);
		List<User> user = crt.list();
		tr.commit();
		return user;
	}

	public User getUserbyId(int id) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria crt = session.createCriteria(User.class);
		User user = session.get(User.class, id);
		tr.commit();
		return user;
	}
	
	public String saveUser(User user) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria crt = session.createCriteria(User.class);
		session.save(user);
		tr.commit();
		return "User saved successfully";
	}

	public String updateUser(User user) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria crt = session.createCriteria(User.class);
		try{
			session.update(user);
			tr.commit();
			return "User updated successfully";
		}
		catch (Exception e) {
			return "User of this id is not present, please enter again";
		}
	}

	public String deleteUser(int id) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria crt = session.createCriteria(User.class);
		User user=session.get(User.class, id);
		try {
		session.delete(user);
		tr.commit();
		return "user deleted successfully";
		}
		catch (Exception e) {
			return "user of this id is not present, please enter again";
		}
	}

	public List<User> getUserbyMovieid(int id) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria crt = session.createCriteria(User.class);
		crt.createAlias("movie", "m");
		crt.add(Restrictions.eq("m.id", id));
		List<User>user=crt.list();
		tr.commit();
		return user;
	}

	public List<String> getUsernameByMovieid(int id) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria crt = session.createCriteria(User.class);
		crt.createAlias("movie", "m");
		crt.add(Restrictions.eq("m.id", id));
		crt.setProjection(Projections.property("username"));
		List<String>username=crt.list();
		tr.commit();
		return username;
	}

	public Integer getMovieidByUsername(String username) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria crt = session.createCriteria(User.class);
		crt.createAlias("movie", "m");
		crt.add(Restrictions.eq("username", username));
		crt.setProjection(Projections.property("movie.id"));
		Integer movieid=(Integer)crt.uniqueResult();
		tr.commit();
		return movieid;
	}

	public List<String> getUsernameByInitialLetter(String letter) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria crt = session.createCriteria(User.class);
		crt.add(Restrictions.like("username",letter+"%"));
		crt.setProjection(Projections.property("username"));
		List<String>username=crt.list();
		tr.commit();
		return username;
	}
	
	public User getUserByid(int userId) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		tr.commit();
        return session.get(User.class, userId);
    }

	public String updateMovied(int userid, int movieid) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria crt = session.createCriteria(User.class);
		try{
			User user = session.get(User.class, userid);
			if(user==null) {
				return "User of this id is not present, please enter again";
			}
			
			Movie movie=session.get(Movie.class, movieid);
			if(movie==null)
			{
				return "Movie of this id is not present, please enter again";
			}
		    user.getMovie().setMovieid(movieid);
		    session.update(user);
			tr.commit();
			return "MovieId updated successfully";
		}
		catch (Exception e) {
			return "An error occurred while updating movieId";
		}
	}

}

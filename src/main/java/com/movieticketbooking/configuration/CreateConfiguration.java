package com.movieticketbooking.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.movieticketbooking.entity.Movie;
import com.movieticketbooking.entity.Screening;
import com.movieticketbooking.entity.Seat;
import com.movieticketbooking.entity.User;

public class CreateConfiguration {

	public SessionFactory createConfiguration() {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(User.class);
		cfg.addAnnotatedClass(Seat.class);
		cfg.addAnnotatedClass(Movie.class);
		cfg.addAnnotatedClass(Screening.class);
		SessionFactory sf=cfg.buildSessionFactory();
		return sf;
	}
}

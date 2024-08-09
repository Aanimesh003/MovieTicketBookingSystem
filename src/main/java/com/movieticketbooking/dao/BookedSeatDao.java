package com.movieticketbooking.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.movieticketbooking.entity.BookedSeat;
import com.movieticketbooking.entity.Movie;
import com.movieticketbooking.entity.Screening;
import com.movieticketbooking.entity.Seat;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;


@Repository
public class BookedSeatDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<BookedSeat> getAllBookedSeat() {
        // Create a TypedQuery to retrieve all BookedSeat entities
        TypedQuery<BookedSeat> query = entityManager.createQuery("SELECT b FROM BookedSeat b", BookedSeat.class);
        return query.getResultList();
    }

    @Transactional
    public BookedSeat getBookedSeatById(int id) {
        return entityManager.find(BookedSeat.class, id);
    }
    @Transactional
    public String updateBookedSeat(BookedSeat bookedSeat) {
        // Find the existing booked seat by ID
        BookedSeat existingBookedSeat = entityManager.find(BookedSeat.class, bookedSeat.getBookedseatid());

        if (existingBookedSeat != null) {
            // Update the seat number
            existingBookedSeat.getSeat().setSeatno(bookedSeat.getSeat().getSeatno());
            // Update the screening details
            existingBookedSeat.getScreening().setDate(bookedSeat.getScreening().getDate());
            existingBookedSeat.getScreening().setPrice(bookedSeat.getScreening().getPrice());

            // Update movie details
            Screening screen = existingBookedSeat.getScreening();
            Movie movie = screen.getMovie();
            movie.setTitle(bookedSeat.getScreening().getMovie().getTitle());
            movie.setDuration(bookedSeat.getScreening().getMovie().getDuration());
            movie.setLeadactor_name(bookedSeat.getScreening().getMovie().getLeadactor_name());
            movie.setRating(bookedSeat.getScreening().getMovie().getRating());
            movie.setCategory(bookedSeat.getScreening().getMovie().getCategory());
            movie.setTheater(bookedSeat.getScreening().getMovie().getTheater());

            // The changes will be automatically persisted due to the transaction
            return "Updated successfully";
        } else {
            return "No booked seat found with id: " + bookedSeat.getBookedseatid();
        }
    }
    
    @Transactional
    public List<Integer> getBookedSeatBySeatid(int id) {
        // JPQL query to retrieve booked seat IDs by seat ID
        TypedQuery<Integer> query = entityManager.createQuery(
            "SELECT b.bookedseatid FROM BookedSeat b WHERE b.seat.seatid = :seatId", Integer.class);
        query.setParameter("seatId", id);
        
        return query.getResultList();
    }

    @Transactional
    public Seat getSeatByBookedseatId(int id) {
        // JPQL query to retrieve the Seat associated with the given booked seat ID
        TypedQuery<Seat> query = entityManager.createQuery(
            "SELECT b.seat FROM BookedSeat b WHERE b.bookedseatid = :bookedSeatId", Seat.class);
        query.setParameter("bookedSeatId", id);
        
        return query.getSingleResult(); // This will return the Seat object or throw an exception if not found
    }

    @Transactional
    public Screening getScreeningByBookedseatId(int id) {
        // JPQL query to retrieve the Screening associated with the given booked seat ID
        TypedQuery<Screening> query = entityManager.createQuery(
            "SELECT b.screening FROM BookedSeat b WHERE b.bookedseatid = :bookedSeatId", Screening.class);
        query.setParameter("bookedSeatId", id);
        
        return query.getSingleResult(); 
}}

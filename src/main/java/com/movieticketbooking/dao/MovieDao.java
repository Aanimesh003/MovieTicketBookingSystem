package com.movieticketbooking.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.movieticketbooking.entity.Movie;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
public class MovieDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public Movie getMoviebyId(int id)
	{
		return entityManager.find(Movie.class,id);
	}
    
	@Transactional
	public String saveMovie(Movie movie) {
		entityManager.persist(movie);
		return "Movie saved";
	}
    
	@Transactional
	public String updateMovie(Movie movie) {            
            Movie existingMovie = entityManager.find(Movie.class, movie.getMovieid());
            if (existingMovie == null) {
                return "Movie of this id is not present, please enter again";
            }
            entityManager.merge(movie); //  using merge to update the existing entity
            return "Movie updated";
        } 
    @Transactional
	public String deleteMovie(int id) {
		
		Movie movie=entityManager.find(Movie.class, id);
			if(movie == null)
			return "Movie of this id is not present, please enter again";
			try
			{
				entityManager.remove(movie);
			}
		catch (Exception e) {
			e.printStackTrace();
			return "An error occurred while deleting the movie";
		}
		return "Movie deleted";
	}
    @Transactional
	public String mergeMovie(Movie movie) {
		
		entityManager.merge(movie);
		return "Movie updated successfully";
	}
    
	public List<Movie> getAllMovie() {
	    TypedQuery<Movie> query = entityManager.createQuery("Select m from Movie m",Movie.class);
		return query.getResultList();
	}
   
	public List<Movie> getAnimationMovie() {
		TypedQuery<Movie> query = entityManager.createQuery("Select m from Movie where m.category = :category",Movie.class);
		query.setParameter("category", "Animated");
		return query.getResultList();
	}
    
	public List<Movie> getHorrorAndTrillerMovie() {
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Movie> criteriaQuery = criteriaBuilder.createQuery(Movie.class);
		Root<Movie> root = criteriaQuery.from(Movie.class);
		
		criteriaQuery.select(root).where(
				criteriaBuilder.or(
				criteriaBuilder.equal(root.get("category"),"Horror"),
				criteriaBuilder.equal(root.get("category"),"Thriller")
				)
				);
		return entityManager.createQuery(criteriaQuery).getResultList();
	}
}

	
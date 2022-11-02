package com.ojt.movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ojt.movie.entity.Category;
import com.ojt.movie.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{

public List<Movie> findByCategory(Category category);
	
	public Movie findByTitle(String title);
	
}

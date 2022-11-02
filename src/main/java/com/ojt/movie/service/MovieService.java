package com.ojt.movie.service;

import java.util.List;

import com.ojt.movie.entity.Category;
import com.ojt.movie.entity.Movie;


public interface MovieService {
	public List<Movie> getAll();

	public Movie get(int id);

	public Movie create(Movie movie);

	public Movie update(int id, Movie movie);

	public boolean delete(int id);

	public List<Movie> getAllByCategory(Category category);

	public Movie getByTitle(String title);

}

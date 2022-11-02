package com.ojt.movie.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojt.movie.entity.Category;
import com.ojt.movie.entity.Movie;
import com.ojt.movie.repository.MovieRepository;
@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	MovieRepository movieRepository;
	
	@Override
	public List<Movie> getAll() {
		return movieRepository.findAll();
	}

	@Override
	public Movie get(int id) {
		return movieRepository.findById(id).orElse(null);
	}

	@Override
	public Movie create(Movie movie) {
		movie.setCreatedAt(LocalDateTime.now());
		return movieRepository.save(movie);
	}

	@Override
	public Movie update(int id, Movie movie) {
		Movie toUpdateMovie = this.get(id);
		if(toUpdateMovie == null) {
			return null;
		}
		toUpdateMovie.setTitle(movie.getTitle());
		toUpdateMovie.setBudget(movie.getBudget());
		toUpdateMovie.setOverview(movie.getOverview());
		toUpdateMovie.setCategory(movie.getCategory());
		toUpdateMovie.setAdult(movie.getAdult());
		toUpdateMovie.setPosterPath(movie.getPosterPath());
		toUpdateMovie.setTrailerPath(movie.getTrailerPath());
		toUpdateMovie.setUpdatedAt(LocalDateTime.now());
		movieRepository.save(toUpdateMovie);
		return toUpdateMovie;
	}

	@Override
	public boolean delete(int id) {
		Movie movie = this.get(id);
		if (movie == null) {
			return false;
		}
		movieRepository.deleteById(id);
		return true;
	}

	@Override
	public List<Movie> getAllByCategory(Category category) {
		return movieRepository.findByCategory(category);
	}

	@Override
	public Movie getByTitle(String title) {
		return movieRepository.findByTitle(title);
	}

}

package com.ojt.movie.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojt.movie.entity.Movie;
import com.ojt.movie.entity.Record;
import com.ojt.movie.entity.User;
import com.ojt.movie.entity.UserRole;
import com.ojt.movie.repository.MovieRepository;
import com.ojt.movie.repository.RecordRepository;
import com.ojt.movie.repository.UserRepository;


@Service
public class RecordServiceImpl implements RecordService {

	@Autowired
	RecordRepository recordRepository;

	@Autowired
	UserRepository userRepository;
	@Autowired
	MovieRepository movieRepository;

	@Override
	public Record create(Record record) {
		// Check User
		User user = userRepository.findById(record.getUser().getId()).orElse(null);
		if (user == null) {
			return null;
		}
		// Check Movie
		Movie movie = movieRepository.findById(record.getMovie().getId())
				.orElse(null);
		if (movie == null) {
			return null;
		}
		// Create Record Only If user role is user
		if (user.getUserRole() == UserRole.user) {
			record.setCreatedAt(LocalDateTime.now());
			return recordRepository.save(record);
		}
		return null;
	}

	@Override
	public Record get(int id) {
		return recordRepository.findById(id).orElse(null);
	}

	@Override
	public List<Record> getAll() {
		return recordRepository.findAll();
	}

	@Override
	public Record update(int id, Record rec) {
		Record record = this.get(id);
		if (record == null) {
			return null;
		}
		record.setUser(rec.getUser());
		record.setMovie(rec.getMovie());
		record.setUpdatedAt(LocalDateTime.now());
		recordRepository.save(record);
		return record;
	}

	@Override
	public boolean delete(int id) {
		Record record = this.get(id);
		if (record == null) {
			return false;
		}
		recordRepository.deleteById(id);
		return true;
	}

	@Override
	public List<Record> getAllByUserID(int userID) {
		User user = new User();
		user.setId(userID);
		return recordRepository.findAllByUser(user);
	}

}

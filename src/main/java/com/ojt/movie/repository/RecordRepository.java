package com.ojt.movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ojt.movie.entity.Record;
import com.ojt.movie.entity.User;

public interface RecordRepository extends JpaRepository<Record, Integer>{

	public List<Record> findAllByUser(User user);
}

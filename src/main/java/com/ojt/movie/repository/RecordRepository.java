package com.ojt.movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ojt.movie.entity.Record;
import com.ojt.movie.entity.User;

@EnableJpaRepositories
public interface RecordRepository extends JpaRepository<Record, Integer>{

	public List<Record> findAllByUser(User user);
}

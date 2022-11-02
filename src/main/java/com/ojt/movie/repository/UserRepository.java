package com.ojt.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ojt.movie.entity.User;

@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Integer>{
	public User findByGmail(String gmail);

	public User findByName(String name);
}

package com.ojt.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ojt.movie.entity.Category;

@EnableJpaRepositories
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}

package com.ojt.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ojt.movie.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}

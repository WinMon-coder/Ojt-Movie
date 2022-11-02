package com.ojt.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojt.movie.entity.Category;
import com.ojt.movie.repository.CategoryRepository;


@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categroyRepository;

	@Override
	public List<Category> getAll() {
		return categroyRepository.findAll();
	}

	@Override
	public Category get(int id) {
		return categroyRepository.findById(id).orElse(null);
	}

	@Override
	public Category create(Category category) {
		return categroyRepository.save(category);
	}

	@Override
	public Category update(int id, Category category) {
		Category toUpdateCategory = this.get(id);
		if (toUpdateCategory == null) {
			return null;
		}
		toUpdateCategory.setId(id);
		toUpdateCategory.setName(category.getName());
		return categroyRepository.save(category);
	}

	@Override
	public boolean delete(int id) {
		Category category = this.get(id);
		if (category == null) {
			return false;
		}
		categroyRepository.deleteById(id);
		return true;
	}

}

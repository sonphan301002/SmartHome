package com.java.service;

import java.util.List;

import com.java.entity.Category;

public interface CategoryService {

	List<Category> findAll();

	Category add(Category category);

	Category update(Category category);

	void delete(Long maDM);

 

}

package com.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.CategoryDAO;
import com.java.entity.Category;
import com.java.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	CategoryDAO categoryDAO;

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return categoryDAO.findAll();
	}

	@Override
	public Category add(Category category) {
		// TODO Auto-generated method stub
		return categoryDAO.save(category);
	}

	@Override
	public Category update(Category category) {
		// TODO Auto-generated method stub
		return categoryDAO.save(category);
	}

	@Override
	public void delete(Long maDM) {
		// TODO Auto-generated method stub
		categoryDAO.deleteById(maDM);
	}

 
}

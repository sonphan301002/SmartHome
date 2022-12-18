package com.java.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.dao.CategoryDAO;
import com.java.entity.Category;
import com.java.service.CategoryService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/categories")
public class CategoryRestController {
	@Autowired
	CategoryService categoryService;
	
	
	@GetMapping
	public List<Category> findAll() {
		return categoryService.findAll();
	}
	
 
	
	@PostMapping
	public Category add(@RequestBody Category category) {
		return categoryService.add(category);
	}
	
	@PutMapping("{maDM}")
	public Category update(@PathVariable("maDM") Long maDM, @RequestBody Category category) {
		return categoryService.update(category);
	}
	
	@DeleteMapping("{maDM}")
	public void delete(@PathVariable("maDM") Long maDM) {
		categoryService.delete(maDM);
	}
}

package com.java.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.entity.Category;

@Repository
public interface CategoryDAO extends JpaRepository<Category, Long>{
	
}

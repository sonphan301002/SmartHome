package com.java.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.entity.Product;

@Repository
public interface ProductDAO extends JpaRepository<Product, Long>{
//	List<SanPham> findByNameContaining(String tenSP);
}

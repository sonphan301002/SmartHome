package com.java.service;

import java.util.List;

 
import com.java.entity.Product;

public interface ProductService {

	List<Product> findAll();
	List<Product> findByCateId(Long string);
	Product save(Product sanPham);
	Product findById(Long maSP);
	void delete(Long maSP);
}

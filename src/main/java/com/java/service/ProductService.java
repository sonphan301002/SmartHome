package com.java.service;

import java.util.List;

 
import com.java.entity.Product;

public interface ProductService {

	List<Product> findAll();

	 

	Product findById(Long maSP);



	List<Product> findByNameContaining(String tenSP);
 
}

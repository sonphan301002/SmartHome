package com.java.service;


import java.util.List;

import com.java.entity.CateStatsReport;
import com.java.entity.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface ProductService {

	List<Product> findAll();
	List<Product> findByCateId(Long string);
	Product save(Product sanPham);
	Product findById(Long maSP);
	Product add(Product product);
	Product update(Product product);
	void delete(Long id);
	
	List<Product> findByTensp(String keyword);
//	Page<Product> findAllByTenspLike(String keyword, Pageable pageable);
//	Page<Product> findAll(Pageable pageable);
    List<Product> findNewProduct();
    List<Product> hienThiThietBi();
    List<Product> hienThiRobot();
    List<Product> hienThimayLoc();
	List<CateStatsReport> getInventoryByCategory();
	Iterable<Product> findAll(Sort sort);
	Page<Product> findAll(Pageable pageable);


 
	
 
}

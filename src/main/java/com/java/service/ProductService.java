package com.java.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.java.entity.CateStatsReport;
import com.java.entity.Product;

public interface ProductService {

	List<Product> findAll();
	List<Product> findByCateId(Long cid);
	
	Product save(Product sanPham);
	Product findById(Long maSP);
	Product add(Product product);
	Product update(Product product);
	void delete(Long id);
	
	List<Product> findByTensp(String keyword);
    List<Product> findNewProduct();
    List<Product> hienThiThietBi();
    List<Product> hienThiRobot();
    List<Product> hienThimayLoc();
    
    List<CateStatsReport> getInventoryByCategory();
    
//	Page<Product> findAll(Pageable pageable);
//	Page<Product> findAllByTenspLike(String keyword, Pageable pageable);
}

package com.java.service;

import java.util.List;

 
import com.java.entity.SanPham;

public interface ProductService {

	List<SanPham> findAll();

	 

	SanPham findById(Long maSP);



	List<SanPham> findByNameContaining(String tenSP);

	 

 
}

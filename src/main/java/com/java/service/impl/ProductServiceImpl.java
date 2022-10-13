package com.java.service.impl;

import java.util.List;

import com.java.dao.ProductDAO;
import com.java.entity.Product;
import com.java.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductDAO productDAO;

	@Override
	public List<Product> findAll() {
		 
		return productDAO.findAll();
	}

	@Override
	public Product findById(Long maSP) {
		 
		return productDAO.findById(maSP).get();
	}

	@Override
	public List<Product> findByCateId(Long string) {
		// TODO Auto-generated method stub
		return productDAO.findByCateId(string);
	}

	@Override
	public Product save(Product sanPham) {
		// TODO Auto-generated method stub
		return productDAO.save(sanPham);
	}

	@Override
	public Product add(Product product) {
		// TODO Auto-generated method stub
		return productDAO.save(product);
	}

	@Override
	public Product update(Product product) {
		// TODO Auto-generated method stub
		return productDAO.save(product);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		productDAO.deleteById(id);
	}

	
}

package com.java.service.impl;

 
import java.util.List;

import com.java.dao.ProductDAO;
import com.java.entity.CateStatsReport;
import com.java.entity.Product;
import com.java.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductDAO productDAO; //truy xuất dữ liệu thông qua DAO

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
	public List<CateStatsReport> getInventoryByCategory() {
		return productDAO.getInventoryByCategory();
	}

	@Override
	public Product update(Product product) {
		// TODO Auto-generated method stub
		return productDAO.save(product);
	}

	@Override
	public void delete(Long maSP) {
		productDAO.deleteById(maSP);
	}
	
	public List<Product> findByTensp(String keyword) {
		return productDAO.findByTensp(keyword);
	}

    @Override
    public List<Product> findNewProduct() {
        // TODO Auto-generated method stub
        return productDAO.findNewProduct();
    }

    @Override
    public List<Product> hienThiThietBi() {
        // TODO Auto-generated method stub
        return productDAO.hienThiThietBi();
    }

    @Override
    public List<Product> hienThiRobot() {
        // TODO Auto-generated method stub
        return productDAO.hienThiRobot();
    }

    @Override
    public List<Product> hienThimayLoc() {
        // TODO Auto-generated method stub
        return productDAO.hienThimayLoc();
    }

	@Override
	public Iterable<Product> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return productDAO.findAll(sort);
	}

	@Override
	public Page<Product> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return productDAO.findAll(pageable);
	}

	 
 
 
 
 

//	@Override
//	public Page<Product> findAllByTenspLike(String keyword, Pageable pageable) {
//		 
//		return productDAO.findAllByTenspLike(keyword, pageable);
//	}
//
 
}

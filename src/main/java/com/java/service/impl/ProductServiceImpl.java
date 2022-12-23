package com.java.service.impl;

 
import java.util.List;

import com.java.dao.ProductDAO;
import com.java.entity.CateStatsReport;
import com.java.entity.Product;
import com.java.repository.ProductRepository;
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

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public List<Product> findAll() {
		return productDAO.findAll();
	}


	@Override
	public Product findById(Long maSP) {
		return productDAO.findById(maSP).get();
	}

	@Override
	public List<Object[]> getDoanhThuNgayHomNay() {
		return productDAO.getDoanhThuNgayHomNay();
	}

	@Override
	public List<Product> findByCateId(Long cid) {
	    return productDAO.findByCateId(cid);
	}

	@Override
	public List<Object[]> getSanPhamBanDuoc() {
		return productDAO.getSanPhamBanDuoc();
	}


	@Override
	public List<CateStatsReport> getInventoryByCategory() {
	    return productDAO.getInventoryByCategory();
	}
	
	@Override
	public Product save(Product sanPham) {
		return productDAO.save(sanPham);
	}

	@Override
	public Product add(Product product) {
		return productDAO.save(product);
	}


	@Override
	public Product update(Product product) {
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
        return productDAO.findNewProduct();
    }

    @Override
    public List<Product> hienThiThietBi() {
        return productDAO.hienThiThietBi();
    }

    @Override
    public List<Product> hienThiRobot() {
        return productDAO.hienThiRobot();
    }

    @Override
    public List<Product> hienThimayLoc() {
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

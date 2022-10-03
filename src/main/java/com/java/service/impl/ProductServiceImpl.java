package com.java.service.impl;

import java.util.List;

import com.java.dao.SanPhamDao;
import com.java.entity.SanPham;
import com.java.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	SanPhamDao sanPhamDao;

	@Override
	public List<SanPham> findAll() {
		 
		return sanPhamDao.findAll();
	}

	@Override
	public SanPham findById(Long maSP) {
		 
		return sanPhamDao.findById(maSP).get();
	}

	@Override
	public List<SanPham> findByCateId(Long string) {
		// TODO Auto-generated method stub
		return sanPhamDao.findByCateId(string);
	}

	@Override
	public List<SanPham> findByBestSeller() {
		// TODO Auto-generated method stub
		return sanPhamDao.findByBestSeller();
	}

	@Override
	public SanPham save(SanPham sanPham) {
		// TODO Auto-generated method stub
		return sanPhamDao.save(sanPham);
	}

	
}

//package com.java.service.impl;
//
//import java.util.List;
//
//import com.java.dao.SanPhamDao;
//import com.java.entity.DanhMuc;
//import com.java.entity.SanPham;
//import com.java.service.ProductService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ProductServiceImpl implements ProductService{
//	@Autowired
//	SanPhamDao spdao;
//
//	@Override
//	public List<SanPham> findAll() {
//		 
//		return spdao.findAll();
//	}
//
//	@Override
//	public SanPham findById(Long maSP) {
//		 
//		return spdao.findById(maSP).get();
//	}
//
//	@Override
//	public List<SanPham> findByNameContaining(String tenSP) {
//		return spdao.findByNameContaining(tenSP);
//	}
//	
//}

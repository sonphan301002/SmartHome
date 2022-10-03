package com.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.DanhMucDao;
import com.java.entity.DanhMuc;
import com.java.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	DanhMucDao danhMucDao;

	@Override
	public List<DanhMuc> findAll() {
		// TODO Auto-generated method stub
		return danhMucDao.findAll();
	}
}

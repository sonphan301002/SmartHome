package com.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.ProductDAO;
import com.java.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService{
	@Autowired
	ProductDAO productDAO;

	@Override
	public List<Object[]> getDoanhThu(int nam) {
		// TODO Auto-generated method stub
		return productDAO.thongKeDoanhThu(nam);
	}
}

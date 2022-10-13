package com.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.SupplierDAO;
import com.java.entity.Supplier;
import com.java.service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService{
	@Autowired
	SupplierDAO supplierDAO;

	@Override
	public List<Supplier> findAll() {
		// TODO Auto-generated method stub
		return supplierDAO.findAll();
	}

	@Override
	public Supplier create(Supplier supplier) {
		// TODO Auto-generated method stub
		return supplierDAO.save(supplier);
	}

	@Override
	public Supplier update(Supplier supplier) {
		// TODO Auto-generated method stub
		return supplierDAO.save(supplier);
	}

	@Override
	public void delete(Long maNCC) {
		// TODO Auto-generated method stub
		supplierDAO.deleteById(maNCC);
	}
}

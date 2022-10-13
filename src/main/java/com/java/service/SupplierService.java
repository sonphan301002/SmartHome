package com.java.service;

import java.util.List;

import com.java.entity.Supplier;

public interface SupplierService {

	List<Supplier> findAll();

	Supplier create(Supplier supplier);

	Supplier update(Supplier supplier);

	void delete(Long maNCC);

}

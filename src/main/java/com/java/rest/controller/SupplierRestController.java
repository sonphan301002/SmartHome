package com.java.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.entity.Supplier;
import com.java.service.SupplierService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/supplieres")
public class SupplierRestController {
	@Autowired
	SupplierService supplierService;
	
	@GetMapping
	public List<Supplier> findAll(){
		return supplierService.findAll();
	}
	
	@PostMapping
	public Supplier create(@RequestBody Supplier supplier) {
		return supplierService.create(supplier);
	}
	
	@PutMapping("{maNCC}")
	public Supplier update(@PathVariable("maNCC") Long maNCC, @RequestBody Supplier supplier) {
		return supplierService.update(supplier);
	}
	
	@DeleteMapping("{maNCC}")
	public void delete(@PathVariable("maNCC") Long maNCC) {
		supplierService.delete(maNCC);
	}
}

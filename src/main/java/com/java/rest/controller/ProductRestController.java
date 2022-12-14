package com.java.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.entity.Product;
import com.java.service.ProductService;

@RestController
@CrossOrigin("*")
@RequestMapping("/rest/products")
public class ProductRestController {
	@Autowired
	ProductService productService;
	
	@GetMapping()
	public List<Product> getAll() {
		return productService.findAll();
	}
	
	@GetMapping("{maSP}")
	public Product getOne(@PathVariable("maSP") Long maSP) {
		return productService.findById(maSP);
	}
	
	@GetMapping("maDM")
	public List<Product> getCateId(@PathVariable("maDM") Long maDM) {
		return productService.findByCateId(maDM);
	}
	
	@PostMapping()
	public Product create(@RequestBody Product product) {
		return productService.save(product);
	}
	
	@PutMapping("{maSP}")
	public Product update(@PathVariable("maSP") Long maSP, @RequestBody Product product) {
	    return productService.update(product);
	}
	
	@DeleteMapping("{maSP}")
	public void delete(@PathVariable("maSP") Long masp) {
		productService.delete(masp);
	}
	
}

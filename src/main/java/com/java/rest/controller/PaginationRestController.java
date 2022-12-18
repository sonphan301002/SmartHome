package com.java.rest.controller;

import java.util.List;
import java.util.Optional;

import com.java.entity.Product;
import com.java.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/rest/paginatons")
public class PaginationRestController {

	@Autowired
	ProductService productService;

	@GetMapping("cid")
	public List<Product> list(Model model, @RequestParam("cid") Optional<Long> cid) { //RequestPa -> tham số tuỳ chọn theo "cid", Optional -> tham số - đưa mã loại
		if (cid.isPresent()) { // nếu có
			return productService.findByCateId(cid.get());
		} else {
			return productService.findAll();
		}
	
	}
	

	
	@GetMapping("{maSP}")
	public Product getOne(@PathVariable("maSP") Long maSP) {
		return productService.findById(maSP);
	}
	
	@GetMapping("maDM")
	public List<Product> getCateId(@PathVariable("maDM") Long maDM) {
		return productService.findByCateId(maDM);
	}
	
}

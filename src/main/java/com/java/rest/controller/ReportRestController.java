package com.java.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.entity.CateStatsReport;
import com.java.entity.Product;
import com.java.service.ProductService;
import com.java.service.ReportService;

@RestController
@CrossOrigin("*")
@RequestMapping("/rest/reports")
public class ReportRestController {
	@Autowired
	ReportService reportService;
	
	@Autowired
	ProductService productService;
	
	@GetMapping()
	public List<CateStatsReport> getAll() {
		return productService.getInventoryByCategory();
	}
	
	@GetMapping({"nam"})
	public List<Object[]> getDoanhThu(int nam){
		return reportService.getDoanhThu(nam);
	}
}

package com.java.controller;

import java.util.List;

import com.java.entity.SanPham;
import com.java.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
//	@Autowired
//	ProductService productService;
//	
//	@RequestMapping("/list")
//	public String list(Model model) {
//		List<SanPham> list = productService.findAll();
//		model.addAttribute("items", list);
//		return "/product/product";
//	}
	
	@RequestMapping("productDetail")
	public String detail(Model model) {
//		SanPham item = productService.findById(maSP);
//		model.addAttribute("item",item);
		return "/product/product-detail";
	}
	
//	@GetMapping("search")
//	public String search(ModelMap model,
//			@RequestParam(name = "tenSP", required = false) String tenSP) {
//		List<SanPham> list = null;
//		
//		if(StringUtils.hasText(tenSP)) {
//			list = productService.findByNameContaining(tenSP);
//			
//	}else {
//		list = productService.findAll();
//	}
//		model.addAttribute("",list);
//		return "search";
//	}
		 
}

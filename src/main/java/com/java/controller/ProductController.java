package com.java.controller;

import java.util.List;
import java.util.Optional;

import com.java.entity.Product;
import com.java.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;

	@RequestMapping("/product/list")
	public String list(Model model, @RequestParam("cid") Optional<Long> cid) {
		if (cid.isPresent()) { // nếu có
			List<Product> list = productService.findByCateId(cid.get());
			model.addAttribute("items", list);
		} else {
			model.addAttribute("items", productService.findAll());
		}
		return "/product/product";
	}
	
	@RequestMapping("productDetail/{maSP}")
	public String detail(Model model, @PathVariable("maSP") Long maSP) {
		Product item = productService.findById(maSP);
		model.addAttribute("item",item);
		
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

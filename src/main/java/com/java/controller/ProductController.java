package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
	@RequestMapping("/list")
	public String list() {
		return "/product/product";
	}
	
	@RequestMapping("productDetail")
	public String detail() {
		return "/product/product-detail";
	}
}

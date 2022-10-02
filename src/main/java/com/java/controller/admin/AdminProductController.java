package com.java.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminProductController {
	@RequestMapping("/admin/product")
	public String product() {
		return "/admin/product/products";
	}
	@RequestMapping("/admin/product-add")
	public String productadd() {
		return "/admin/product/add-product";
	}

}

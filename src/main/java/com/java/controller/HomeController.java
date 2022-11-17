package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.service.AccountService;
import com.java.service.ProductService;

@Controller
public class HomeController {
	@Autowired
	ProductService productService;
	
	@Autowired
	AccountService accountService;
	
	@RequestMapping("/")
	public String home(Model model) {
	    model.addAttribute("taiKhoan", accountService.findAll());
		model.addAttribute("bestSeller", productService.findAll());
		model.addAttribute("newProd", productService.findNewProduct());
		model.addAttribute("thietBi", productService.hienThiThietBi());
		model.addAttribute("roBot", productService.hienThiRobot());
		model.addAttribute("mayloc", productService.hienThimayLoc());
		return "/layout/main";
	}
	
	@RequestMapping("/review")
	public String review() {
		return "/layout/review";
	}
	
	@RequestMapping("/news")
	public String news() {
		return "/layout/news";
	}
	
	@RequestMapping("/manuals")
	public String manuals() {
		return "/layout/manuals";
	}
	
	@RequestMapping("/discount")
	public String discount() {
		return "/layout/discount";
	}
	
	@RequestMapping("/contact")
	public String contact() {
		return "/layout/contact";
	}
 
	
 
}

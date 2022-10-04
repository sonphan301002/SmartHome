package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	@RequestMapping("/index")
	public String home() {
		return "redirect:/index";
	}
	
	@RequestMapping("admin/index")
	public String admin() {
		return "redirect:/admin/home.html";
	}
}

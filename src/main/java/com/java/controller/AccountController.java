package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccountController {
	@RequestMapping("/Login")
	public String login() {
		return "/account/login";
	}
	
	@RequestMapping("/change")
	public String change() {
		return "/account/change-password";
	}
	
	@RequestMapping("/editProfile")
	public String editProfile() {
		return "/account/edit-profile";
	}
	
	@RequestMapping("/forgot")
	public String fogot() {
		return "/account/forgot-password";
	}
}

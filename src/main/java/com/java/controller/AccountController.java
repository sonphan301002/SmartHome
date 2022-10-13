package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("security")
public class AccountController {
	
    @GetMapping("/login/form")
	public String login(Model model) {
        model.addAttribute("message", "Vui lòng đăng nhập");
		return "/account/login";
	}
    
    @GetMapping("/login/success")
    public String loginSuccess(Model model){
        model.addAttribute("message", "Đăng nhập thành công");
        return "/layout/main";
    }
    
    @GetMapping("login/error")
    public String loginError(Model model){
        model.addAttribute("message", "Tên đăng nhập hoặc mật khẩu không chính xác !");
        return "account/login";
    }
    
    @GetMapping("/logoff/success")
    public String logOffSuccess(Model model){
        model.addAttribute("message", "Đăng xuất thành công");
        return "/layout/main";
    }
    
	
    @GetMapping("/change")
	public String change() {
		return "/account/change-password";
	}
	
    @GetMapping("/editProfile")
	public String editProfile() {
		return "/account/edit-profile";
	}
	
    @GetMapping("/forgot")
	public String fogot() {
		return "/account/forgot-password";
	}
}

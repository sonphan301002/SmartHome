package com.java.controller;


import javax.validation.Valid;

import com.java.entity.Account;
import com.java.service.AccountService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("security")
public class AccountController {
    
    @Autowired
    AccountService accountService;
    
    @GetMapping("/login/form")
	public String login(Model model, Account account) {
        model.addAttribute("message", "Vui lòng đăng nhập");
		return "/account/login";
	}
    
    @GetMapping("/login/success")
    public String loginSuccess(Model model){
        model.addAttribute("message", "Đăng nhập thành công");
        return "redirect:/";
    }
    
    @GetMapping("login/error")
    public String loginError(Model model){
        model.addAttribute("message", "Tên đăng nhập hoặc mật khẩu không chính xác !");
        return "account/login";
    }
    
    @GetMapping("/logoff/success")
    public String logOffSuccess(Model model){
        model.addAttribute("message", "Đăng xuất thành công");
        return "redirect:/";
    }
    
    @PostMapping("/register")
    public String dangky(ModelMap model, 
            @Valid @ModelAttribute("customer") 
    Account dto,BindingResult result){
        
        
//      nếu có lỗi -> nạp lại trang registration
        if (result.hasErrors()) {
            return "/account/login";
        }
        
        //Tạo ra đối tượng entity
        Account entity = new Account();
        
        //Copy dữ liệu từ đối tượng dto -> entity
        BeanUtils.copyProperties(dto, entity);
        
        //Lưu thông tin entity vào CSDL
        entity.setDiaChi("");
        entity.setGioiTinh(true);
        entity.setHoTen("");
        accountService.save(entity);
        
        
        //Hiển thị thông báo
        model.addAttribute("message", "Đăng ký tài khoản thành công !");
        
        return "/account/login";
    }
    
    @GetMapping("/change")
	public String change() {
		return "/account/change-password";
	}
	
    @GetMapping("/editProfile/{tenND}")
	public String editProfile(ModelMap model, @PathVariable("tenND") String tenND){
    	
    	Account acc = accountService.getById(tenND);
    	model.addAttribute("acc", acc);
		return "/account/edit-profile";
	}
	
    @GetMapping("/forgot")
	public String fogot() {
		return "/account/forgot-password";
	}
    
    @PostMapping("/changeInfomation")
    public String changeInfomation(ModelMap model ,@Valid
    		@ModelAttribute("acc") Account item, BindingResult result){
    	
    	if (result.hasErrors()) {
    		return "/account/edit-profile";
		}
        
    	accountService.save(item);
        
        //Hiển thị thông báo
        model.addAttribute("message", "Cập nhật thông tin thành công !");
    	return "/account/edit-profile";
	}
}

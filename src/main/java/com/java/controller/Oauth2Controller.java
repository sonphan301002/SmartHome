package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.entity.Account;
import com.java.entity.AuthenticationProvider;
import com.java.service.AccountService;

import com.java.service.AccountService;


@Controller
@RequestMapping("oauth2")
public class Oauth2Controller {
    
    @Autowired
    AccountService accountService;
	
    
    //Login Oauth2 success 
    @GetMapping("/login/success")
    public String loginSuccess(OAuth2AuthenticationToken oauth){
        
        //Đọc thông tin tài khoản mạng xã hội
        String email = oauth.getPrincipal().getAttribute("email");
        String fullname = oauth.getPrincipal().getAttribute("name");
        
        
        System.out.println("Account is "+email);


        //Tìm kiếm account theo email
        Account account = accountService.getById(email);

        //Nếu chưa có acc với email tìm được
        if (account == null) {
//            ->Tạo mới
            accountService.createNewAccountAfterOauthLoginSuccess(email, fullname, AuthenticationProvider.GOOGLE);
        }else {

//            update nếu có acc với email tìm được
            accountService.updateAccountAfterOauthLoginSuccess(account, fullname, AuthenticationProvider.GOOGLE);
        }
        
        
        
        //Tạo đối tượng userdetails lấy email làm username
        UserDetails user = User.withUsername(email).password("").roles("GUEST").build();
        
        //Tạo đối tượng authentication từ userdetails
        Authentication auth=
                new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
        
        //Thay đổii thông tin đăng nhập
        SecurityContextHolder.getContext().setAuthentication(auth);
        
        return "redirect:/";
    }
    
}

package com.java.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.java.service.CategoryService;

@Component
public class CategoryInterceptor implements HandlerInterceptor{
	@Autowired
	CategoryService categoryService;
	
	@Override
	//postHandle: sử dụng để thực hiện các hoạt động trước khi gửi request tới client 
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		request.setAttribute("cates", categoryService.findAll()); // tạo attr "cate", lấy tất cả các loại trong cateservice -> findAll 
	}
}

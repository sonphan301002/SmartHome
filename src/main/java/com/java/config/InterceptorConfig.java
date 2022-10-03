package com.java.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.java.interceptor.CategoryInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
	@Autowired
	CategoryInterceptor categoryInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(categoryInterceptor) //đưa global vào hệ thống
		.addPathPatterns("/**") // chỉ ra các url
		.excludePathPatterns("/rest/**", "/admin/**", "/assets/**"); // loại trừ các địa chỉ k cần thiết
	}
}

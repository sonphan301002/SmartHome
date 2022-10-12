package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.entity.Order;
import com.java.service.OrderService;

@Controller
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@RequestMapping("/order")
	public String order(Model model) {
		return "/order/order";
	}
	
	@RequestMapping("/orderDetail/{maHD}")
	public String orderDetail() {
		return "/order/orderdetail";
	}
}

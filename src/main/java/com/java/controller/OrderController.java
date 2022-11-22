package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.entity.Order;
import com.java.entity.OrderDetail;
import com.java.service.AccountService;
import com.java.service.OrderService;

@Controller
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@Autowired
	AccountService accountService;
	
	@RequestMapping("/order")
	public String order(Model model, HttpServletRequest request) {
		String tenND = request.getRemoteUser();
		model.addAttribute("orders", orderService.findByUsername(tenND));
		return "/order/order";
	}
	
	@RequestMapping("/order/orderDetail/{maHD}")
	public String orderDetail(Model model,
	        @PathVariable("maHD") Long maHD) {
	    Order order = orderService.findById(maHD);
		model.addAttribute("order", order);
		return "/order/orderdetail";
	}
	
	@RequestMapping("/order/checkout/{username}")
	public String checkout(Model model, @PathVariable("username") String username) {
	    model.addAttribute("taiKhoan", accountService.findByND(username));
	    return "/order/checkout";
	}
}

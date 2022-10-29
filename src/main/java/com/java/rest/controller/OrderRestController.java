package com.java.rest.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.java.entity.Order;
import com.java.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orders")
public class OrderRestController {
    @Autowired
    OrderService orderService;


    @GetMapping
    public List<Order> getAll() {
        return orderService.findAll();
    }
    
    @PostMapping()
    public Order create(@RequestBody JsonNode orderData) {
        return orderService.create(orderData);
    }
    
    @PutMapping("{maHD}")
    public Order update(@PathVariable("maHD") Long maHD, @RequestBody Order order){
        return orderService.update(order);
    }

}
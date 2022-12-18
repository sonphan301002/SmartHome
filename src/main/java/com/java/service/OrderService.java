package com.java.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.java.entity.Order;
import com.java.entity.OrderDetail;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {
    List<Order> findAll();

    Order findById(Long maHD);
    
    List<Order> findByUsername(String tenND);
    
    List<OrderDetail> findByMaHD(Long maHD);

    Order create(JsonNode orderData);
    
    Order update(Order order);

    Page<Order> findByUsernamePage(String tenND, Pageable pageable);
}

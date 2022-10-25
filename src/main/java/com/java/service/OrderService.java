package com.java.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.java.entity.Order;
import com.java.entity.OrderDetail;

import java.util.List;

public interface OrderService {
    List<Order> findAll();

    List<OrderDetail> findByMaHD(Long maHD);

    Order update(Order order);


    Order create(JsonNode orderData);

	Order findById(Long maHD);

	List<Order> findByUsername(String tenND);
}

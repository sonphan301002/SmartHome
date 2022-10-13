package com.java.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.java.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAll();
    Order create(JsonNode orderData);

}

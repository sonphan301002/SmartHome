package com.java.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.dao.OrderDAO;
import com.java.dao.OrderDetailDAO;
import com.java.entity.Order;
import com.java.entity.OrderDetail;
import com.java.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDAO odao;

    @Autowired
    OrderDetailDAO oddao;

    @Override
    public List<Order> findAll() {
        return odao.findAll();
    }
    
    @Override
    public Order findById(Long maHD) {
        return odao.findById(maHD).get();
    }

    @Override
    public List<OrderDetail> findByMaHD(Long maHD) {
        return oddao.findByMaHD(maHD);
    }

    @Override
    public Order update(Order order){
        return odao.save(order);
    }

    @Override
    public Order create(JsonNode orderData) {
        ObjectMapper mapper = new ObjectMapper();

        Order order = mapper.convertValue(orderData, Order.class);
        odao.save(order);

        TypeReference<List<OrderDetail>> type = new TypeReference<>() {};
        List<OrderDetail> details = mapper.convertValue(orderData.get("hoaDonChiTiet"), type)
                .stream().peek(d -> d.setHoaDon(order)).collect(Collectors.toList());
        oddao.saveAll(details);

        return order;
    }

    @Override
    public List<Order> findByUsername(String tenND) {
        return odao.findByUsername(tenND);
    }
}

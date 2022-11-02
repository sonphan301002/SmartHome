package com.java.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.java.entity.OrderDetail;

import java.util.List;

@Repository
public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long>{
    @Query("select odd FROM OrderDetail odd where odd.hoaDon.maHD = ?1")
    List<OrderDetail> findByMaHD(Long maHD);
}

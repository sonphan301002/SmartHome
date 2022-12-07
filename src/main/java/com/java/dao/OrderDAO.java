package com.java.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.java.entity.Order;

@Repository
public interface OrderDAO extends JpaRepository<Order, Long>{
	@Query("SELECT o FROM Order o WHERE o.taiKhoan.tenND = ?1 ORDER BY maHD DESC")
	List<Order> findByUsername(String username);
	
}

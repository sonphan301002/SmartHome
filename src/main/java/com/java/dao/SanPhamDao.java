package com.java.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.entity.SanPham;

public interface SanPhamDao extends JpaRepository<SanPham, Long>{

}

package com.java.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

 
import com.java.entity.SanPham;

public interface SanPhamDao extends JpaRepository<SanPham, Long>{
	List<SanPham> findByNameContaining(String tenSP);
}

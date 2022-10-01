package com.java.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.java.entity.DanhMuc;

public interface DanhMucDao extends JpaRepository<DanhMuc, Long>{
	
}

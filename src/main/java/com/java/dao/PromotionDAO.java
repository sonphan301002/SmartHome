package com.java.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.entity.Promotion;

@Repository
public interface PromotionDAO extends JpaRepository<Promotion, Long>{

}

package com.java.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.entity.Image;

@Repository
public interface ImageDAO extends JpaRepository<Image, Long>{

}

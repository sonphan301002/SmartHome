package com.java.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.entity.Supplier;

@Repository
public interface SupplierDAO extends JpaRepository<Supplier, Long>{

}

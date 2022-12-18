package com.java.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.java.entity.Product;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    List<Product> findBydanhMuc(Long cid, Pageable pageable);
}

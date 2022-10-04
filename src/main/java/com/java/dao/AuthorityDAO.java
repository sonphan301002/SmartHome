package com.java.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.entity.Authority;

@Repository
public interface AuthorityDAO extends JpaRepository<Authority, Long>{

}

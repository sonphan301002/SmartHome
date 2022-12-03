package com.java.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.java.entity.Account;
import com.java.entity.Authority;

@Repository
public interface AuthorityDAO extends JpaRepository<Authority, Long>{
	
	@Query("select distinct a from Authority a where a.taiKhoan in ?1")
	List<Authority> authoritiesOf(List<Account> accounts);

}

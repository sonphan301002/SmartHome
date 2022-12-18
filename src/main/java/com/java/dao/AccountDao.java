package com.java.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.java.entity.Account;

@Repository
public interface AccountDao extends JpaRepository<Account, String>{
	
	@Query("select DISTINCT ar.taiKhoan from Authority ar where ar.vaiTro.maVT IN ('GD', 'NV')")
	List<Account> getAdministrators();
	
	Account findByEmail(String email);
	
	@Query("SELECT acc from Account acc WHERE acc.tenND=:username and acc.email=:email")
	Account findByUsernameandEmail(String username,String email);
}

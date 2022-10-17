package com.java.service;

import java.util.List;

import java.util.Optional;


import com.java.entity.Account;
import com.java.entity.AuthenticationProvider;

import org.springframework.security.core.Authentication;

public interface AccountService {
    
    Account create(Account account);

    void delete(String tenND);


	List<Account> getAdministrators();

	
	
    Account getById(String tenND);

    void delete(Account entity);

    void deleteById(String tenND);

    boolean existsById(String tenND);

    Optional<Account> findById(String tenND);

    <S extends Account> S save(S entity);

    List<Account> findAll();

    Account findByND(String tenND);

    Account update(Account account);

    Account findByEmail(String email);

    void createNewAccountAfterOauthLoginSuccess(String email, String name, AuthenticationProvider provider);

    void updateAccountAfterOauthLoginSuccess(Account account, String name, AuthenticationProvider provider);


//    Account getUserByUsername(String username);


}

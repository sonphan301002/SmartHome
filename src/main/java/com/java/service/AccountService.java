package com.java.service;

import java.util.List;

import java.util.Optional;


import com.java.entity.Account;

public interface AccountService {
    
    Account create(Account account);

    Account update(Account account);

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

}

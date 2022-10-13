package com.java.service;

import java.util.List;
import java.util.Optional;

import com.java.entity.Account;

public interface AccountService {

	List<Account> getAdministrators();

	List<Account> findAll();
	
    Account getById(String tenND);

    void delete(Account entity);

    void deleteById(String tenND);

    boolean existsById(String tenND);

    Optional<Account> findById(String tenND);

    <S extends Account> S save(S entity);
}

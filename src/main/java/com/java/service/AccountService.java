package com.java.service;

import java.util.List;
import java.util.Optional;

import com.java.entity.Account;

public interface AccountService {

    Account getById(String tenND);

    void delete(Account entity);

    void deleteById(String tenND);

    boolean existsById(String tenND);

    Optional<Account> findById(String tenND);

    List<Account> findAll();

    <S extends Account> S save(S entity);

}

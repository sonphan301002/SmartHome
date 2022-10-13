package com.java.service;

import java.util.List;

import com.java.entity.Account;

public interface AccountService {
    List<Account> findAll();
    
    Account findById(String tenND);
    
    Account create(Account account);

    Account update(Account account);

    void delete(String tenND );
}

package com.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.AccountDao;
import com.java.entity.Account;
import com.java.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    public Account findById(String tenND) {
        return accountDao.findById(tenND).get();
    }

    @Override
    public Account create(Account account) {
        return accountDao.save(account);
    }

    @Override
    public Account update(Account account) {
        return accountDao.save(account);
    }

    @Override
    public void delete(String tenND) {
        accountDao.deleteById(tenND);

        
    }

}

package com.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.AccountDao;
import com.java.entity.Account;
import com.java.service.AccountService;

@Service
public class AccountServiceImpl implements  AccountService{
	@Autowired
	AccountDao accountDao;

	@Override
	public List<Account> getAdministrators() {
		// TODO Auto-generated method stub
		return accountDao.getAdministrators();
	}

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return accountDao.findAll();
	}
}

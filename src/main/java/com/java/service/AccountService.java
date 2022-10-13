package com.java.service;

import java.util.List;

import com.java.entity.Account;

public interface AccountService {

	List<Account> getAdministrators();

	List<Account> findAll();

}

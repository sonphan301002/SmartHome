package com.java.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.AccountDao;
import com.java.entity.Account;
import com.java.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	AccountDao accountDAO;

    @Override
    public <S extends Account> S save(S entity) {
        return accountDAO.save(entity);
    }

    @Override
    public List<Account> findAll() {
        return accountDAO.findAll();
    }

    @Override
    public Optional<Account> findById(String tenND) {
        return accountDAO.findById(tenND);
    }

    @Override
    public boolean existsById(String tenND) {
        return accountDAO.existsById(tenND);
    }

    @Override
    public void deleteById(String tenND) {
        accountDAO.deleteById(tenND);
    }

    @Override
    public void delete(Account entity) {
        accountDAO.delete(entity);
    }

    @Override
    public Account getById(String tenND) {
        return accountDAO.getById(tenND);
    }

	@Override
	public List<Account> getAdministrators() {
		// TODO Auto-generated method stub
		return null;
	}
}

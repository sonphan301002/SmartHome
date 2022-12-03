package com.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.AccountDao;
import com.java.dao.AuthorityDAO;
import com.java.entity.Account;
import com.java.entity.Authority;
import com.java.service.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService{
	@Autowired
	AuthorityDAO authorityDAO;
	@Autowired
	AccountDao accountDao;

	@Override
	public List<Authority> findAuthoritiesOfAdministrators() {
		// TODO Auto-generated method stub
		List<Account> accounts = accountDao.getAdministrators();
		return authorityDAO.authoritiesOf(accounts);
	}

	@Override
	public List<Authority> findAll() {
		// TODO Auto-generated method stub
		return authorityDAO.findAll();
	}

	@Override
	public Authority create(Authority authority) {
		// TODO Auto-generated method stub
		return authorityDAO.save(authority);
	}

	@Override
	public void delete(Long maPQ) {
		// TODO Auto-generated method stub
		authorityDAO.deleteById(maPQ);
	}

}

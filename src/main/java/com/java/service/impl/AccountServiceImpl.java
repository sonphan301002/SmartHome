package com.java.service.impl;

import java.util.List;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.java.dao.AccountDao;
import com.java.entity.Account;
import com.java.entity.AuthenticationProvider;
import com.java.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
	public Account findByUsernameandEmail(String username, String email) {
		return accountDao.findByUsernameandEmail(username, email);
	}

	@Override
    public Account findByND(String tenND) {
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
    
    @Override
    public <S extends Account> S save(S account) {
//        Optional<Account> optExist = findById(account.getTenND());
//        
//        //kiểm tra nếu người dùng kh nhập password
//        if (optExist.isPresent()) {
//            
//            //Lấy password cũ
//            if (StringUtils.isEmpty(account.getMatKhau())) {
//                account.setMatKhau(null);
//            
//            }else {// nhập password
//                
////              -> mã hóa password
//                account.setMatKhau(bCryptPasswordEncoder.encode(account.getMatKhau()));
//            }
//        }
//        
//        account.setMatKhau(bCryptPasswordEncoder.encode(account.getMatKhau()));
        
        return accountDao.save(account);
    }

    @Override
    public boolean existsById(String tenND) {
        return accountDao.existsById(tenND);
    }

    @Override
    public void deleteById(String tenND) {
        accountDao.deleteById(tenND);
    }

    @Override
    public void delete(Account entity) {
        accountDao.delete(entity);
    }

    @SuppressWarnings("deprecation")
	@Override
    public Account getById(String tenND) {
        return accountDao.getById(tenND);
    }

	@Override
	public List<Account> getAdministrators() {
		// TODO Auto-generated method stub
		return accountDao.getAdministrators();
	}
	
    @Override
    public Optional<Account> findById(String tenND) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }
    
    
    @Override
    public Account findByEmail(String email) {
        return accountDao.findByEmail(email);
    }
    
    @Override
    public void createNewAccountAfterOauthLoginSuccess(String email, String name, AuthenticationProvider provider) {
        Account account = new Account();
        account.setTenND(email);
        account.setEmail(email);
        account.setHoTen(name);
        account.setAuthProvider(provider);

        accountDao.save(account);
    }

    @Override
    public void updateAccountAfterOauthLoginSuccess(Account account, String name, AuthenticationProvider provider) {
        account.setHoTen(name);
        account.setAuthProvider(provider);

        accountDao.save(account);
    }

}

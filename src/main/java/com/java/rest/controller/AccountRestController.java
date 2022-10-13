package com.java.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.entity.Account;
import com.java.service.AccountService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/account")
public class AccountRestController {
    @Autowired
    AccountService accountService;
    
    @GetMapping()
    public List<Account> getAll(){
        return accountService.findAll();
    }
    
    @GetMapping("{tenND}")
    public Account getOne(@PathVariable("tenND") String tenND) {
        return accountService.findById(tenND);
    }
    
    @PostMapping
    public Account create (@RequestBody Account account) {
        return accountService.create(account);
    }
    
    @PutMapping("{tenND}")
    public Account update (@PathVariable("tenND") String tenND, @RequestBody Account account) {
        return accountService.update(account);
    }
    
    @DeleteMapping("{tenND}")
    public void delete(@PathVariable("tenND") String tenND){
         accountService.delete(tenND);
    }



}

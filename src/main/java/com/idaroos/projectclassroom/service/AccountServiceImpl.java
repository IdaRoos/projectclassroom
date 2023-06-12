package com.idaroos.projectclassroom.service;


import com.idaroos.projectclassroom.dao.AccountRepository;
import com.idaroos.projectclassroom.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository AccountRepository){
        this.accountRepository = accountRepository;
    }
    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findById(int id) {
        return null;
    }

    @Override
    public void save(Account account) {

    }

    @Override
    public String update(Account account) {
        return null;
    }

    @Override
    public void delete(Account account) {

    }
}

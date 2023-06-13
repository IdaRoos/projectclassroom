package com.idaroos.projectclassroom.service;


import com.idaroos.projectclassroom.dao.AccountRepository;
import com.idaroos.projectclassroom.entity.Account;
import com.idaroos.projectclassroom.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }
    @Override
    public List<Account> findAllByOrderByAuthorityId() {
        return accountRepository.findAllByOrderByAuthorityId();
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findByUsername(String username) {

        Optional<Account> result = accountRepository.findById(username);
        Account account;

        if(result.isPresent()) {
            account = result.get();
        } else {
            throw new RuntimeException("Did not find the user with username: " + username);
        }

        return account;
    }

    @Override
    public void save(Account account) {
        accountRepository.save(account);

    }

    @Override
    public void createNewAccount(User user) {


//        save(account);
    }

    @Override
    public String update(Account account) {
        accountRepository.save(account);
        return "Account with username " + account.getUsername() + " has been updated successfully.";
    }

    @Override
    public void delete(Account account) {
        accountRepository.delete(account);

    }

    @Override
    public Account findByUserId(int id) {
        return accountRepository.findByUserId(id);
    }
}

package com.idaroos.projectclassroom.service;

import com.idaroos.projectclassroom.entity.Account;
import com.idaroos.projectclassroom.entity.User;

import java.util.List;

public interface AccountService {


    List<Account> findAllByOrderByAuthorityId();
    List<Account> findAll();

    Account findByUsername(String username);

    void save(Account account);

    void createNewAccount(User user);

    String update(Account account);
    void delete(Account account);

    Account findByUserId(int id);

    List<Account> findAllByAuthorityId(int id);
}

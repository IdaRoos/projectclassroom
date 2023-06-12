package com.idaroos.projectclassroom.service;

import com.idaroos.projectclassroom.entity.Account;
import com.idaroos.projectclassroom.entity.User;

import java.util.List;

public interface AccountService {


    List<Account> findAllByOrderByAuthorityId(int id);
    List<Account> findAll();

    Account findByUsername(String username);

    void save(Account account);

    String update(Account account);
    void delete(Account account);
}

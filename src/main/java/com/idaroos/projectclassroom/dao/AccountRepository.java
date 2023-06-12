package com.idaroos.projectclassroom.dao;

import com.idaroos.projectclassroom.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, String> {

    public List<Account> findAllByOrderByAuthorityId();
}

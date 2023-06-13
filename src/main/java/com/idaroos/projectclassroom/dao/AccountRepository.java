package com.idaroos.projectclassroom.dao;

import com.idaroos.projectclassroom.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, String> {

    @Query(value = "SELECT * FROM account ORDER BY authority_id DESC", nativeQuery = true)
    List<Account> findAllByOrderByAuthorityId();

    @Query(value = "SELECT * FROM account WHERE user_id = ?", nativeQuery = true)
    Account findByUserId(int userId);
}

package com.idaroos.projectclassroom.dao;

import com.idaroos.projectclassroom.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, String> {

    @Query(value = "SELECT * FROM account ORDER BY authority_id", nativeQuery = true)
    List<Account> findAllByOrderByAuthorityId();
}

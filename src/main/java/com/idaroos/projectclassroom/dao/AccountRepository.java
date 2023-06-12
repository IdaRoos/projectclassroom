package com.idaroos.projectclassroom.dao;

import com.idaroos.projectclassroom.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}

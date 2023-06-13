package com.idaroos.projectclassroom.service;

import com.idaroos.projectclassroom.entity.Account;
import com.idaroos.projectclassroom.entity.Authority;

import java.util.List;

public interface AuthorityService {

   void save(Authority authority);

   String update(Authority authority);

   void delete(Authority authority);

   Authority findById(int id);

   List<Authority> findAll();
}

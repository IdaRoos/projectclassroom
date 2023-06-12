package com.idaroos.projectclassroom.service;

import com.idaroos.projectclassroom.entity.Authority;

public interface AuthorityService {

   void save(Authority authority);

   String update(Authority authority);

   void delete(Authority authority);
}

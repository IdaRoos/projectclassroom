package com.idaroos.projectclassroom.dao;

import com.idaroos.projectclassroom.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
}

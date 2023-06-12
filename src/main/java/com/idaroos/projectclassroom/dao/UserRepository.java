package com.idaroos.projectclassroom.dao;

import com.idaroos.projectclassroom.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}

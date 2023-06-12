package com.idaroos.projectclassroom.dao;

import com.idaroos.projectclassroom.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findAllByOrderByLastNameAsc();
}

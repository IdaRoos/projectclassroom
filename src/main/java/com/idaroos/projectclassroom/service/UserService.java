package com.idaroos.projectclassroom.service;

import com.idaroos.projectclassroom.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    User findById(int id);

    void save(User user);

    String update(User user);
    void delete(User user);


}

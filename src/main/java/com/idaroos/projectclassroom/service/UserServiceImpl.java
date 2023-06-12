package com.idaroos.projectclassroom.service;

import com.idaroos.projectclassroom.dao.TeacherCourseRepository;
import com.idaroos.projectclassroom.dao.UserRepository;
import com.idaroos.projectclassroom.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public List<User> findAll() {
        return userRepository.findAllByOrderByLastname();
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public String update(User user) {
        return null;
    }

    @Override
    public void delete(User user) {

    }
}

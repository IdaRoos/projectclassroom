package com.idaroos.projectclassroom.service;

import com.idaroos.projectclassroom.dao.UserRepository;
import com.idaroos.projectclassroom.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

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
        Optional<User> result = userRepository.findById(id);
        User user;

        if(result.isPresent()) {
            user = result.get();
        } else {
            throw new RuntimeException("Did not find the user with id: " + id);
        }

        return user;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public String update(User user) {
        return "User " + user.getFirstName() + " has been updated.";
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);

    }
}

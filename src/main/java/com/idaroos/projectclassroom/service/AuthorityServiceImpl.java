package com.idaroos.projectclassroom.service;

import com.idaroos.projectclassroom.dao.AccountRepository;
import com.idaroos.projectclassroom.dao.AuthorityRepository;
import com.idaroos.projectclassroom.entity.Authority;
import com.idaroos.projectclassroom.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorityServiceImpl implements AuthorityService{


    private final AuthorityRepository authorityRepository;

    @Autowired
    public AuthorityServiceImpl(AuthorityRepository authorityRepository){
        this.authorityRepository = authorityRepository;
    }
    @Override
    public void save(Authority authority) {
        authorityRepository.save(authority);

    }



    @Override
    public String update(Authority authority) {
authorityRepository.save(authority);
        return "Authority was updated successfully";
    }

    @Override
    public void delete(Authority authority) {
        authorityRepository.delete(authority);

    }

    @Override
    public Authority findById(int id) {
        Optional<Authority> result = authorityRepository.findById(id);
        Authority authority;

        if (result.isPresent()) {
            authority = result.get();
        } else {
            throw new RuntimeException("Did not find the authority with id: " + id);
        }

        return authority;

    }
}

package com.idaroos.projectclassroom.controller;


import com.idaroos.projectclassroom.entity.Account;
import com.idaroos.projectclassroom.entity.Authority;
import com.idaroos.projectclassroom.entity.User;
import com.idaroos.projectclassroom.service.AccountService;
import com.idaroos.projectclassroom.service.AuthorityService;
import com.idaroos.projectclassroom.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/classroom/users")
public class UsersController {

    private UserService userService;

    private AccountService accountService;

    private AuthorityService authorityService;

    public UsersController(UserService userService, AccountService accountService, AuthorityService authorityService) {
        this.userService = userService;
        this.accountService = accountService;
        this.authorityService = authorityService;
    }

    @GetMapping("")
    public String showUsersList(Model theModel) {
        List<Map<String, Object>> usersWithAuthorities = userService.findAllUsersWithAuthorities();
        theModel.addAttribute("usersWithAuthorities", usersWithAuthorities);

        return "userList";
    }





}

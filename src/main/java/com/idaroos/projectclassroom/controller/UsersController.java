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
        // get the employees from db
        List<User> theUsers = userService.findAllByLastName();

        // add to the spring model
        theModel.addAttribute("users", theUsers);

        return "userList";
    }

    @PostMapping("/createAccount")
    public String createAccount(@RequestParam int userId) {

        User user = userService.findById(userId);
        // create new account object
        Account account = new Account(user.getFirstName(), user.getFirstName(), Timestamp.valueOf(LocalDateTime.now()), null);

        account.setAuthority(authorityService.findById(1));
        account.setUser(user);

        // save account object
        accountService.save(account);
        return "redirect:/classroom/users";
    }


}

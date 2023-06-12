package com.idaroos.projectclassroom.controller;


import com.idaroos.projectclassroom.entity.User;
import com.idaroos.projectclassroom.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/classroom/users")
public class UsersController {

    private UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String showUsersList(Model theModel){
        // get the employees from db
        List<User> theUsers = userService.findAllByLastName();

        // add to the spring model
        theModel.addAttribute("users", theUsers);

        return "userList";
    }

    @PostMapping("/createAccount")
    public String createAccount(@ModelAttribute("users") User user) {
        // get user information

        // create new account object

        // save account object
        return "redirect:/classroom/userList";
    }



}

package com.idaroos.projectclassroom.controller;


import com.idaroos.projectclassroom.entity.Account;
import com.idaroos.projectclassroom.entity.Course;
import com.idaroos.projectclassroom.entity.User;
import com.idaroos.projectclassroom.service.AccountService;
import com.idaroos.projectclassroom.service.AuthorityService;
import com.idaroos.projectclassroom.service.CourseService;
import com.idaroos.projectclassroom.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/admin")
public class AdminController {

    UserService userService;

    AccountService accountService;

    AuthorityService authorityService;

    CourseService courseService;
    public AdminController(UserService userService,AccountService accountService, AuthorityService authorityService, CourseService courseService) {
        this.userService = userService;
        this.accountService = accountService;
        this.authorityService = authorityService;
        this.courseService = courseService;
    }

    @GetMapping("/showFormForAdd")
    public String addUser(Model theModel){
// create model attribute to bind form data
        User newUser = new User();

        theModel.addAttribute("user", newUser);

        return "userform";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User newUser){
        // save the User
        userService.save(newUser);
        // use a redirect to prevent duplicate submissions
        return "redirect:/admin/showFormForAdd";
    }

    @GetMapping("/addCourse")
    public String addCourse(Model theModel){
// create model attribute to bind form data
        Course newCourse= new Course();

        theModel.addAttribute("course", newCourse);

        return "courseform";
    }


    @PostMapping("/saveCourse")
    public String saveUser(@ModelAttribute("user") Course newCourse){
        // save the User
        courseService.save(newCourse);
        // use a redirect to prevent duplicate submissions
        return "redirect:/admin/addCourse";
    }

    @PostMapping("/createAccount")
    public String createAccount(@RequestParam int userId, @RequestParam int authorityId) {

        User user = userService.findById(userId);
        // create new account object
        Account account = new Account(user.getFirstName(), user.getFirstName(), Timestamp.valueOf(LocalDateTime.now()), null);

        account.setAuthority(authorityService.findById(authorityId));
        account.setUser(user);

        // save account object
        accountService.save(account);
        return "redirect:/classroom/users";
    }

    @PostMapping("/updateRole")
    public String updateAccountRole(@RequestParam int userId, @RequestParam int authorityId){
        Account account = accountService.findByUserId(userId);

        account.setAuthority(authorityService.findById(authorityId));

        accountService.save(account);

        return "redirect:/classroom/users";
    }

    @GetMapping("/systems")
    public String showSystemsPage(){
        return "adminsystems";
    }

}

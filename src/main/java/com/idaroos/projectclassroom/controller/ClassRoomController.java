package com.idaroos.projectclassroom.controller;


import com.idaroos.projectclassroom.entity.User;
import com.idaroos.projectclassroom.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/classroom")
public class ClassRoomController {

    UserService userService;

    public ClassRoomController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/home")
    public String showMainPage() {
        return "home";
    }

    @GetMapping("/showFormForAdd")
    public String addUser(Model theModel){
// create model attribute to bind form data
        User newUser = new User();

        theModel.addAttribute("user", newUser);

        return "userform";
    }


    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User newUser){
        // save the User
        userService.save(newUser);
        // use a redirect to prevent duplicate submissions
        return "redirect:/classroom/showFormForAdd";
    }

    @GetMapping("/users")
    public String showStudentList(){
        return "userList";
    }

    @GetMapping("/createAccount")
    public String createAccount() {
        return "redirect:/classroom/userList";
    }
}

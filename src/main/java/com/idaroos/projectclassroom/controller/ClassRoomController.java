package com.idaroos.projectclassroom.controller;


import com.idaroos.projectclassroom.entity.User;
import com.idaroos.projectclassroom.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/classroom")
public class ClassRoomController {

    @GetMapping("/home")
    public String showMainPage() {
        return "home";
    }





}

package com.idaroos.projectclassroom.controller;


import com.idaroos.projectclassroom.entity.Course;
import com.idaroos.projectclassroom.entity.User;
import com.idaroos.projectclassroom.service.CourseService;
import com.idaroos.projectclassroom.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/classroom/admin")
public class AdminController {

    UserService userService;

    CourseService courseService;
    public AdminController(UserService userService, CourseService courseService) {
        this.userService = userService;
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
        return "redirect:/classroom/admin/showFormForAdd";
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
        return "redirect:/classroom/admin/addCourse";
    }

}

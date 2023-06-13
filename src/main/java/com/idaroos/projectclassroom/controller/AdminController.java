package com.idaroos.projectclassroom.controller;


import com.idaroos.projectclassroom.entity.*;
import com.idaroos.projectclassroom.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    UserService userService;

    AccountService accountService;

    AuthorityService authorityService;

    CourseService courseService;

    StudentCourseService studentCourseService;

    TeacherCourseService teacherCourseService;
    public AdminController(UserService userService,AccountService accountService, AuthorityService authorityService, CourseService courseService, StudentCourseService studentCourseService, TeacherCourseService teacherCourseService) {
        this.userService = userService;
        this.accountService = accountService;
        this.authorityService = authorityService;
        this.courseService = courseService;
        this.studentCourseService = studentCourseService;
        this.teacherCourseService = teacherCourseService;
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

    @GetMapping("/students/courses")
    public String showStudentCourse(Model model){
        List<Course> courseList = courseService.findAll();
        model.addAttribute("courses", courseList);

        List<Account> studentList = accountService.findAllByAuthorityId(1);

        model.addAttribute("students",studentList);

        return "addstudentcourse";
    }

    @GetMapping("/teachers/courses")
    public String showTeacherCourse(Model model){
        List<Course> courseList = courseService.findAll();
        model.addAttribute("courses", courseList);

        List<Account> teacherList = accountService.findAllByAuthorityId(2);

        model.addAttribute("teachers",teacherList);
        return "addteachercourse";

    }

    @PostMapping("/students/addStudentCourse")
    public String addStudentCourse(@RequestParam String username, @RequestParam int courses, Model model){
        StudentCourse newCourse = new StudentCourse();
        Course studentCourse = courseService.findById(courses);
        Account studentAccount = accountService.findByUsername(username);

        newCourse.setCourse(studentCourse);
        newCourse.setAccount(studentAccount);

        try{
            studentCourseService.save(newCourse);

        } catch(IllegalArgumentException e){
           model.addAttribute("duplicateCourseError", e.getMessage());
            return showStudentCourse(model);
        }

        return "redirect:/admin/students/courses";
    }

    @PostMapping("/teachers/addTeacherCourse")
    public String addTeacherCourse(@RequestParam String username, @RequestParam int courses, Model model) {
        TeacherCourse newCourse = new TeacherCourse();
        Course teacherCourse = courseService.findById(courses);
        Account teacherAccount = accountService.findByUsername(username);

        newCourse.setCourse(teacherCourse);
        newCourse.setAccount(teacherAccount);

        try{
            teacherCourseService.save(newCourse);

        } catch(IllegalArgumentException e){
            model.addAttribute("duplicateCourseError", e.getMessage());
            return showTeacherCourse(model);
        }

        return "redirect:/admin/teachers/courses";
    }


}

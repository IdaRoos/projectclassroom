package com.idaroos.projectclassroom.controller;

import com.idaroos.projectclassroom.entity.Account;
import com.idaroos.projectclassroom.entity.Course;
import com.idaroos.projectclassroom.entity.StudentCourse;
import com.idaroos.projectclassroom.entity.TeacherCourse;
import com.idaroos.projectclassroom.service.AccountService;
import com.idaroos.projectclassroom.service.CourseService;
import com.idaroos.projectclassroom.service.StudentCourseService;
import com.idaroos.projectclassroom.service.TeacherCourseService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/classroom")
public class ClassRoomController {

    private StudentCourseService studentCourseService;

    private TeacherCourseService teacherCourseService;

    private AccountService accountService;

    private CourseService courseService;

    public ClassRoomController(StudentCourseService studentCourseService, TeacherCourseService teacherCourseService, AccountService accountService, CourseService courseService) {
        this.studentCourseService = studentCourseService;
        this.teacherCourseService = teacherCourseService;
        this.accountService = accountService;
        this.courseService = courseService;
    }

    @GetMapping("/home")
    public String showMainPage(Model model) {

        // SecurityContextHolder - This class contains the details of the security data associated with the current execution
        // getContext() - returns the securityContext object. (details of the currently authenticated user)
        // getAuthentication() = - returns Authentication object that contains the principal like userdetails, username and authority.
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Save to principal object
        Object principal = authentication.getPrincipal();

        Account loggedInAccount;
        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();

            loggedInAccount = accountService.findByUsername(username);
            model.addAttribute("loggedInUser", loggedInAccount);

            if(loggedInAccount.getAuthority().getId() == 1) {

                List<Map<String, Object>> studentCourseInfoList = studentCourseService.findCourseAndTeacherByStudentUsername(username);
                model.addAttribute("courseInfo", studentCourseInfoList);
            }else if(loggedInAccount.getAuthority().getId() == 2) {

                List<Map<String, Object>> teacherCourseInfoList = teacherCourseService.findCourseAndTeacherByTeacherUsername(username);
                model.addAttribute("courseInfo", teacherCourseInfoList);

            }else {
                // Hämta alla kurser för admin
            }

        }
        return "home";
    }


}

package com.idaroos.projectclassroom.service;

import com.idaroos.projectclassroom.entity.StudentCourse;
import com.idaroos.projectclassroom.entity.User;

import java.util.List;

public interface StudentCourseService {

    void save(StudentCourse StudentCourse);

    String update(StudentCourse studentCourse);

    void delete(StudentCourse studentCourse);

    List<StudentCourse> findAllStudentsByCourseId(int id);

    List<StudentCourse> findAllCoursesByUsername(String username);

}
package com.idaroos.projectclassroom.service;

import com.idaroos.projectclassroom.entity.StudentCourse;
import com.idaroos.projectclassroom.entity.User;

import java.util.List;
import java.util.Map;

public interface StudentCourseService {

    void save(StudentCourse studentCourse);

    String update(StudentCourse studentCourse);

    void delete(StudentCourse studentCourse);

    List<StudentCourse> findAllStudentsByCourseId(int id);

    List<StudentCourse> findAllCoursesByUsername(String username);

    List<StudentCourse> findAll();

    List<Map<String, Object>> findCourseAndTeacherByStudentUsername(String username);

}

package com.idaroos.projectclassroom.service;

import com.idaroos.projectclassroom.entity.StudentCourse;
import com.idaroos.projectclassroom.entity.TeacherCourse;

import java.util.List;
import java.util.Map;

public interface TeacherCourseService {


    void save(TeacherCourse teacherCourse);

    String update(TeacherCourse teacherCourse);

    void delete(TeacherCourse teacherCourse);

    String findTeacherNameByCourseId(int id);

    List<TeacherCourse> findAllCoursesByUsername(String username);

    List<TeacherCourse> findAll();

    List<Map<String, Object>> findCourseAndTeacherByTeacherUsername(String username);
}

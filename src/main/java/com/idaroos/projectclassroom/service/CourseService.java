package com.idaroos.projectclassroom.service;

import com.idaroos.projectclassroom.entity.Account;
import com.idaroos.projectclassroom.entity.Authority;
import com.idaroos.projectclassroom.entity.Course;

import java.util.List;

public interface CourseService {

    void save(Course course);

    String update(Course Course);

    void delete(Course course);

    List<Course> findAll();

    Course findById(int id);
}

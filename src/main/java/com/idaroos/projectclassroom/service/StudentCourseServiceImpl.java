package com.idaroos.projectclassroom.service;

import com.idaroos.projectclassroom.dao.CourseRepository;
import com.idaroos.projectclassroom.dao.StudentCourseRepository;
import com.idaroos.projectclassroom.entity.StudentCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCourseServiceImpl implements StudentCourseService{

    private StudentCourseRepository studentCourseRepository;

    @Autowired
    public StudentCourseServiceImpl(StudentCourseRepository studentCourseRepository){
        this.studentCourseRepository = studentCourseRepository;
    }
    @Override
    public void save(StudentCourse StudentCourse) {

    }

    @Override
    public String update(StudentCourse studentCourse) {
        return null;
    }

    @Override
    public void delete(StudentCourse studentCourse) {

    }

    @Override
    public List<StudentCourse> findAllStudentsByCourseId(int id) {
        return null;
    }

    @Override
    public List<StudentCourse> findAllCoursesByUsername(String username) {
        return null;
    }
}

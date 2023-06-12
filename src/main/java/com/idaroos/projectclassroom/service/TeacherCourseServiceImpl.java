package com.idaroos.projectclassroom.service;

import com.idaroos.projectclassroom.dao.StudentCourseRepository;
import com.idaroos.projectclassroom.dao.TeacherCourseRepository;
import com.idaroos.projectclassroom.entity.StudentCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherCourseServiceImpl implements StudentCourseService{

    private TeacherCourseRepository teacherCourseRepository;

    @Autowired
    public TeacherCourseServiceImpl(TeacherCourseRepository teacherCourseRepository){
        this.teacherCourseRepository = teacherCourseRepository;
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

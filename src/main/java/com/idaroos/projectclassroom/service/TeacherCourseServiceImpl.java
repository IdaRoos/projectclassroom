package com.idaroos.projectclassroom.service;

import com.idaroos.projectclassroom.dao.StudentCourseRepository;
import com.idaroos.projectclassroom.dao.TeacherCourseRepository;
import com.idaroos.projectclassroom.entity.StudentCourse;
import com.idaroos.projectclassroom.entity.TeacherCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TeacherCourseServiceImpl implements TeacherCourseService{

    private TeacherCourseRepository teacherCourseRepository;

    @Autowired
    public TeacherCourseServiceImpl(TeacherCourseRepository teacherCourseRepository){
        this.teacherCourseRepository = teacherCourseRepository;
    }
    @Override
    public void save(TeacherCourse teacherCourse) {
        List<TeacherCourse> teacherCourseList = findAll();

        for (TeacherCourse theTeacherCourse : teacherCourseList) {
            if (theTeacherCourse.getCourse() == teacherCourse.getCourse() && theTeacherCourse.getAccount() == teacherCourse.getAccount()) {
                throw new IllegalArgumentException("Course already assigned to this teacher");

            }
        }
            teacherCourseRepository.save(teacherCourse);
    }

    @Override
    public String update(TeacherCourse teacherCourse) {
        teacherCourseRepository.save(teacherCourse);
        return "Teacher's course was successfully updated.";
    }

    @Override
    public void delete(TeacherCourse teacherCourse) {
teacherCourseRepository.delete(teacherCourse);
    }

    @Override
    public String findTeacherNameByCourseId(int id) {
return teacherCourseRepository.findTeacherNameByCourseId(id);

    }

    @Override
    public List<TeacherCourse> findAllCoursesByUsername(String username) {
return teacherCourseRepository.findAllCoursesByUsername(username);
    }

    @Override
    public List<TeacherCourse> findAll() {
        return teacherCourseRepository.findAll();
    }

    @Override
    public List<Map<String, Object>> findCourseAndTeacherByTeacherUsername(String username) {
        return teacherCourseRepository.findCourseAndTeacherByTeacherUsername(username);
    }
}

package com.idaroos.projectclassroom.service;

import com.idaroos.projectclassroom.dao.AuthorityRepository;
import com.idaroos.projectclassroom.dao.CourseRepository;
import com.idaroos.projectclassroom.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    private CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }
    @Override
    public void save(Course course) {

    }

    @Override
    public String update(Course Course) {
        return null;
    }

    @Override
    public void delete(Course course) {

    }

    @Override
    public List<Course> findAll() {
        return null;
    }

    @Override
    public Course findById(int id) {
        return null;
    }
}

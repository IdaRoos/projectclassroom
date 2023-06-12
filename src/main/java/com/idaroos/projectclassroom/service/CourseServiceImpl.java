package com.idaroos.projectclassroom.service;

import com.idaroos.projectclassroom.dao.AuthorityRepository;
import com.idaroos.projectclassroom.dao.CourseRepository;
import com.idaroos.projectclassroom.entity.Account;
import com.idaroos.projectclassroom.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{

    private CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }
    @Override
    public void save(Course course) {
courseRepository.save(course);
    }

    @Override
    public String update(Course course) {
        courseRepository.save(course);
        return "Course has been updated";
    }

    @Override
    public void delete(Course course) {
courseRepository.delete(course);
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(int id) {
        Optional<Course> result = courseRepository.findById(id);
        Course course;

        if(result.isPresent()) {
            course = result.get();
        } else {
            throw new RuntimeException("Did not find the course with id: " + id);
        }

        return course;
    }
}

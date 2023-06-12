package com.idaroos.projectclassroom.dao;

import com.idaroos.projectclassroom.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}

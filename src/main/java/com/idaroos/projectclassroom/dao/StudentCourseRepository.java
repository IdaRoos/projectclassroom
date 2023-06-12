package com.idaroos.projectclassroom.dao;

import com.idaroos.projectclassroom.entity.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, Integer> {
}
